import { Partie } from './../../../models/partie';
import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Composition } from 'src/app/models/composition';
import { Unite } from 'src/app/models/unite';
import { CompositionService } from 'src/app/services/composition.service';
import { PartieService } from 'src/app/services/partie.service';

@Component({
  selector: 'app-composition-liste',
  templateUrl: './composition-liste.component.html',
  styleUrls: ['./composition-liste.component.css'],
})
export class CompositionListeComponent {
  compositions: Composition[] = [];
  idp!: number;
  partie!: Partie;
  constructor(
    private compositionSrv: CompositionService,

    private router: Router,
    private activatedRoute: ActivatedRoute,
    private partieSrv: PartieService
  ) {}

  // ngOnInit(): void {
  //   this.composition=new Composition();
  //   this.activatedRoute.params.subscribe((params) => {
  //   this.partieSrv.getById(params['id']).subscribe((res) => {
  //      this.composition.parties = new Set<Partie>();
  //       this.composition.parties.add(res);
  //   });
  //   this.compositions = this.compositionSrv.getCompositions();
  //   this.activatedRoute.params.subscribe((params) => {
  //     if (params['id']) {
  //       this.partieSrv.getById(params['id']).subscribe((res) => {
  //         // this.composition.parties = new Set<Partie>();
  //         //  this.composition.parties.add(res);
  //       });
  //     }
  //   });
  // }

  ngOnInit(): void {
    this.idp = this.activatedRoute.snapshot.params['id'];
    this.partieSrv.getById(this.idp).subscribe((res) => {
      this.partie = res;

      this.compositions.push(this.partie.compoIA!);
      this.compositions.push(this.partie.compoJoueur!);
      console.log(this.compositions);
    });
  }

  delete(id: number) {
    this.compositionSrv.deleteById(id).subscribe(() => {});
  }
}
