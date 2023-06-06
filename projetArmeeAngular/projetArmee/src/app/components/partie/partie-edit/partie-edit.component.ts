import { Component } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Partie } from 'src/app/models/partie';
import { PartieService } from 'src/app/services/partie.service';

@Component({
  selector: 'app-partie-edit',
  templateUrl: './partie-edit.component.html',
  styleUrls: ['./partie-edit.component.css'],
})
export class PartieEditComponent {
  partie!: Partie;

  constructor(
    private partieSrv: PartieService,
    private router: Router,
    private activatedRoute: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.partie = new Partie();
    this.activatedRoute.params.subscribe((params) => {
      if (params['id']) {
        this.partieSrv.getById(params['id']).subscribe((res) => {
          this.partie = res;
        });
      }
    });
  }

  save() {
    if (this.partie.id) {
      this.partieSrv.update(this.partie).subscribe((res) => {
        this.router.navigateByUrl('/partie');
      });
    } else {
      this.partieSrv.create(this.partie).subscribe((res) => {
        this.router.navigateByUrl('/partie');
      });
    }
  }
}
