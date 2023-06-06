import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Arme } from 'src/app/models/arme';
import { Armee } from 'src/app/models/armee';
import { Composition } from 'src/app/models/composition';
import { TypeA, TypeAValues } from 'src/app/models/type-a';
import { Unite } from 'src/app/models/unite';
import { ArmeService } from 'src/app/services/arme.service';
import { ArmeeService } from 'src/app/services/armee.service';
import { CompositionService } from 'src/app/services/composition.service';
import { UniteService } from 'src/app/services/unite.service';

@Component({
  selector: 'app-unite-edit',
  templateUrl: './unite-edit.component.html',
  styleUrls: ['./unite-edit.component.css'],
})
export class UniteEditComponent implements OnInit {
  obsUnites!: Observable<Unite[]>;
  obsArmes!: Observable<Arme[]>;
  obsArmees!: Observable<Armee[]>;
  selectedarme: Set<Arme> = new Set<Arme>();
  selectedarmee!: Armee;
  selectedObjects: any;
  uniteactuelle!: Unite;
  tabArmes: Arme[] = [];
  arme!: Arme;

  constructor(
    private uniteSrv: UniteService,
    private armeSrv: ArmeService,
    private armeeSrv: ArmeeService,
    private compoSrv: CompositionService,
    private acroute: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.obsArmes = this.armeSrv.getArmes();
    console.log(this.obsArmes, 'Armes');
    this.obsArmees = this.armeeSrv.getArmees();
    console.log(this.obsArmees, 'arme');
    this.uniteactuelle = new Unite();
    this.arme = new Arme();
  }
  weapons: TypeA[] = TypeAValues;
  selectedWeapons: Set<TypeA> = new Set();

  delete(id: number) {
    this.uniteSrv.deleteById(id).subscribe(() => {
      this.obsUnites = this.uniteSrv.getUnites();
    });
  }

  crrerunite() {
    this.uniteactuelle.prix = 0;
    for (let a of this.selectedarme) {
      this.uniteactuelle.prix! += a.typeA?.prix!;
    }

    this.acroute.params.subscribe((params) => {
      const compositionId = params['id'];
      this.compoSrv.getById(compositionId).subscribe((composition) => {
        this.uniteactuelle.composition = composition;
        this.uniteactuelle.armes = this.tabArmes;
        this.uniteactuelle.armee = this.selectedarmee;
        this.creationdesarmes();

        this.uniteSrv.create(this.uniteactuelle).subscribe((res) => {
          this.router.navigateByUrl('nvparti-list');
        });
      });
    });
  }

  creationdesarmes() {
    this.creationdesarmes;
    for (let a of this.selectedarme) {
      let arme = { typeA: a.typeA?.name };

      this.armeSrv.create(arme).subscribe((armeCreee) => {
        this.tabArmes.push(armeCreee);
        console.log('Armée created:', armeCreee);
      });
    }
  }
  toggleWeaponSelection(event: any, weapon: TypeA) {
    if (event.target.checked) {
      let arme: Arme = new Arme();
      arme.typeA = weapon;
      this.selectedarme.add(arme);
    } else {
      for (let a of this.selectedarme) {
        if (a.typeA == weapon) {
          this.selectedarme.delete(a);
        }
      }
    }
  }

  // toggleSelection(obj: Arme) {
  //   if (obj.checked) {
  //     this.selectedarme.add(obj);
  //   } else {
  //     this.selectedarme.delete(obj);
  //   }
  // }
}
