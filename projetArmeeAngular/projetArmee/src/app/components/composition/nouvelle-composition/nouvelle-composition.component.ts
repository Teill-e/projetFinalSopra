import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { from } from 'rxjs';
import { Composition } from 'src/app/models/composition';
import { Partie } from 'src/app/models/partie';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { CompositionService } from 'src/app/services/composition.service';
import { PartieService } from 'src/app/services/partie.service';

@Component({
  selector: 'app-nouvelle-composition',
  templateUrl: './nouvelle-composition.component.html',
  styleUrls: ['./nouvelle-composition.component.css'],
})
export class NouvelleCompositionComponent {
  composition!: Composition;
  compositionIA: Composition = new Composition();

  partie!: Partie;

  constructor(
    private compositionSrv: CompositionService,
    private partieSrv: PartieService,
    private activatedRoute: ActivatedRoute,
    private router: Router,
    private authSrv: AuthenticationService
  ) {}

  ngOnInit(): void {
    this.composition = new Composition();
    this.composition.budget = 500;
    this.compositionIA.budget = 500;

    this.activatedRoute.params.subscribe((params) => {
      if (params['id']) {
        this.partieSrv.getById(params['id']).subscribe((res) => {
          this.partie = res;
          this.partie.compoJoueur = this.composition;
          this.partie.compoIA = this.compositionIA;

          console.log(this.partie);
          this.save();
        });
      }
    });
  }

  save() {
    this.partieSrv.insertCompo(this.partie).subscribe((res) => {
      //this.router.navigateByUrl('/unites-edit');
      this.router.navigateByUrl('/unites-edit/${this.composition.id}');
    });
  }
}
