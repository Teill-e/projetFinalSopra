import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Arme } from 'src/app/models/arme';
import { TypeA, TypeAValues } from 'src/app/models/type-a';
import { ArmeService } from 'src/app/services/arme.service';

@Component({
  selector: 'app-creation-armes',
  templateUrl: './creation-armes.component.html',
  styleUrls: ['./creation-armes.component.css'],
})
export class CreationArmesComponent {
  arme: Arme = new Arme();
  selectedTypeA: TypeA | undefined;
  armes: TypeA[] = TypeAValues;
  // typeAData = this.typeAValues;

  constructor(private armeSrv: ArmeService, private router: Router) {}

  compare(arme1: TypeA, arme2: TypeA): boolean {
    if (!arme1 && arme2) {
      return true;
    } else if (!arme2) {
      return false;
    }
    return arme1 == arme2;
  }
  save() {
    this.arme.typeA = this.selectedTypeA;

    console.log(this.arme);
    this.armeSrv.create(this.arme).subscribe((armeCreee) => {
      this.router.navigateByUrl('/menu-admin');
    });
  }
}
