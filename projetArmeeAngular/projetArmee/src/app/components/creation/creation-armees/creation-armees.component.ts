import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Armee } from 'src/app/models/armeeAir';
import { Pays } from 'src/app/models/pays';
import { ArmeeService } from 'src/app/services/armee.service';

@Component({
  selector: 'app-creation-armees',
  templateUrl: './creation-armees.component.html',
  styleUrls: ['./creation-armees.component.css'],
})
export class CreationArmeesComponent {
  selectedPays: Pays | undefined;
  paysValues = Object.values(Pays);
  armee: Armee = new Armee();

  constructor(private armeeSrv: ArmeeService, private router: Router) {}

  save() {
    this.armeeSrv.create(this.armee).subscribe((armeeCreee) => {
      this.router.navigateByUrl('/menu-admin');
    });
  }
}
