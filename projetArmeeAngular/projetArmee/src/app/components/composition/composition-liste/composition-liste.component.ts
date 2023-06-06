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
  compositions!: Observable<Composition[]>;
  idp!: number;
  compoactuel!: Composition;

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
    this.compoactuel = new Composition();
    this.idp = this.activatedRoute.snapshot.params['id'];
    //this.compositions = this.compositionSrv.getCompositionsbyparti(this.idp);
    this.compositions = this.compositionSrv.getCompositions();
    console.log(this.compositions);
  }

  delete(id: number) {
    this.compositionSrv.deleteById(id).subscribe(() => {
      this.compositions = this.compositionSrv.getCompositions();
    });
  }
}
