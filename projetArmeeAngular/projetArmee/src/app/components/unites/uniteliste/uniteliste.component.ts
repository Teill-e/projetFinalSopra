import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Unite } from 'src/app/models/unite';
import { ArmeService } from 'src/app/services/arme.service';
import { ArmeeService } from 'src/app/services/armee.service';
import { CompositionService } from 'src/app/services/composition.service';
import { UniteService } from 'src/app/services/unite.service';

@Component({
  selector: 'app-uniteliste',
  templateUrl: './uniteliste.component.html',
  styleUrls: ['./uniteliste.component.css'],
})
export class UnitelisteComponent implements OnInit {
  obsUnites!: Observable<Unite[]>;
  constructor(
    private uniteSrv: UniteService,
    private armeSrv: ArmeService,
    private armeeSrv: ArmeeService,
    private compoSrv: CompositionService,
    private acroute: ActivatedRoute,
    private router: Router
  ) {}
  ngOnInit(): void {
    this.obsUnites = this.uniteSrv.getUnites();
    console.log(this.obsUnites, 'tpt');
  }
}
