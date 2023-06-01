import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Partie } from 'src/app/models/partie';
import { PartieService } from 'src/app/services/partie.service';

@Component({
  selector: 'app-joueur-liste-parties',
  templateUrl: './joueur-liste-parties.component.html',
  styleUrls: ['./joueur-liste-parties.component.css'],
})
export class JoueurListePartiesComponent implements OnInit {
  obsParties!: Observable<Partie[]>;

  constructor(private partieSrv: PartieService) {}

  ngOnInit(): void {
    this.obsParties = this.partieSrv.getParties();
  }

  deletePartie(id: number) {
    this.partieSrv.deleteById(id).subscribe(() => {
      this.obsParties = this.partieSrv.getParties();
    });
  }
}
