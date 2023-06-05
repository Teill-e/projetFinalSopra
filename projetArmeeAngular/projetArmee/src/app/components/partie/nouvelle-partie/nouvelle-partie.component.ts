import { ActivatedRoute, Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { Partie } from 'src/app/models/partie';
import { PartieService } from 'src/app/services/partie.service';
import { AuthenticationService } from 'src/app/services/authentication.service';

@Component({
  selector: 'app-nouvelle-partie',
  templateUrl: './nouvelle-partie.component.html',
  styleUrls: ['./nouvelle-partie.component.css'],
})
export class NouvellePartieComponent implements OnInit {
  partie!: Partie;

  constructor(
    private partieSrv: PartieService,
    private activatedRoute: ActivatedRoute,
    private router: Router,
    private authSrv: AuthenticationService
  ) {}

  ngOnInit(): void {
    this.partie = new Partie();
    this.partie.date = new Date();
    this.partie.fin = false;
    this.partie.joueur = this.authSrv.joueurSession();
    this.save();
  }

  save() {
    this.partieSrv.create(this.partie).subscribe((res) => {
      this.router.navigateByUrl('/listeparties');
    });
  }
}
