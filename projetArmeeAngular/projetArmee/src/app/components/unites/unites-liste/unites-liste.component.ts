import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Unite } from 'src/app/models/unite';
import { UniteService } from 'src/app/services/unite.service';

@Component({
  selector: 'app-unites-liste',
  templateUrl: './unites-liste.component.html',
  styleUrls: ['./unites-liste.component.css'],
})
export class UnitesListeComponent implements OnInit {
  obsUnites!: Observable<Unite[]>;

  constructor(private uniteSrv: UniteService) {}

  ngOnInit(): void {
    this.obsUnites = this.uniteSrv.getUnites();
  }

  delete(id: number) {
    this.uniteSrv.deleteById(id).subscribe(() => {
      this.obsUnites = this.uniteSrv.getUnites();
    });
  }
}
