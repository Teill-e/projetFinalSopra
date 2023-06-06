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
    this.acroute.params.subscribe((params) => {
      const compositionId = params['id'];
      this.compoSrv
        .getById(compositionId)
        .subscribe((composition: Composition) => {
          this.uniteactuelle.composition = composition;
          this.armeSrv.create(this.arme);
          this.uniteactuelle.armes = this.selectedarme;
          this.uniteactuelle.prix = 500;
          this.uniteactuelle.armee = this.selectedarmee;
        });
    });
    this.uniteSrv.create(this.uniteactuelle);
    console.log(this.uniteactuelle, 'tot');
    this.uniteSrv.update(this.uniteactuelle);
  }
  toggleWeaponSelection(event: any, weapon: TypeA) {
    if (this.selectedWeapons.has(weapon)) {
      this.selectedWeapons.delete(weapon);
    } else {
      this.arme.typeA = weapon;
      this.selectedarme.add(this.arme);
      console.log(this.selectedarme);
      this.selectedWeapons.add(weapon);
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
