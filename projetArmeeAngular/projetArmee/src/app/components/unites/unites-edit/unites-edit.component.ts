import { Armee } from './../../../models/armee';
import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Arme } from 'src/app/models/arme';
import { Composition } from 'src/app/models/composition';
import { Unite } from 'src/app/models/unite';
import { CompositionService } from 'src/app/services/composition.service';
import { UniteService } from 'src/app/services/unite.service';

@Component({
  selector: 'app-unites-edit',
  templateUrl: './unites-edit.component.html',
  styleUrls: ['./unites-edit.component.css'],
})
export class UnitesEditComponent {
  unite!: Unite;

  constructor(
    private uniteSrv: UniteService,
    private compositionSrv: CompositionService,
    private aR: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.unite = new Unite();

    this.unite.armee = new Armee();
    this.unite.armes = new Set<Arme>();
    this.unite.prix = 500;
    this.aR.params.subscribe((params) => {
      if (params['id']) {
        this.compositionSrv
          .getById(params['id'])
          .subscribe((uniteJson: Composition) => {
            this.unite.composition = uniteJson;
            console.log(this.unite);
          });
      }
    });
    this.save();
  }

  save() {
    // if (this.unite.id) {
    //   this.uniteSrv.update(this.unite).subscribe(() => {
    //     this.router.navigate(['/unite']);
    //   });
    // } else {
    this.uniteSrv.create(this.unite).subscribe((uniteCree) => {
      this.router.navigateByUrl('/unites-liste');
    });
  }
}
