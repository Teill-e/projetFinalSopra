import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Arme } from 'src/app/models/arme';
import { Armee } from 'src/app/models/armee';
import { Unite } from 'src/app/models/unite';
import { ArmeService } from 'src/app/services/arme.service';
import { ArmeeService } from 'src/app/services/armee.service';
import { UniteService } from 'src/app/services/unite.service';

@Component({
  selector: 'app-unites-liste',
  templateUrl: './unites-liste.component.html',
  styleUrls: ['./unites-liste.component.css'],
})
export class UnitesListeComponent implements OnInit {
  obsUnites!: Observable<Unite[]>;
  obsArmes!: Observable<Arme[]>;
  obsArmees!: Observable<Armee[]>;
  selectedarme: Set<Arme> = new Set<Arme>();
  selectedarmee: Set<Armee> = new Set<Armee>();
  selectedObjects: any;

  constructor(
    private uniteSrv: UniteService,
    private armeSrv: ArmeService,
    private armeeSrv: ArmeeService
  ) {}

  ngOnInit(): void {
    this.obsArmes = this.armeSrv.getArmes();
    console.log(this.obsArmes);
    this.obsArmees = this.armeeSrv.getArmees();
    console.log(this.obsArmees);
  }

  delete(id: number) {
    this.uniteSrv.deleteById(id).subscribe(() => {
      this.obsUnites = this.uniteSrv.getUnites();
    });
  }

  toggleSelection(obj: Arme) {
    if (obj.checked) {
      this.selectedarme.add(obj);
    } else {
      this.selectedarme.delete(obj);
    }
  }
  toggleSelectionarme(obj: Armee) {
    if (obj.checked) {
      this.selectedarmee.add(obj);
    } else {
      this.selectedarmee.delete(obj);
    }
  }
}
