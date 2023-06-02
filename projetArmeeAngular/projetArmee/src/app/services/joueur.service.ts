import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class JoueurService {
  private static URL: string = 'http://localhost:8080/armee/api/compte';
  constructor(private httpJoueur: HttpClient) {}

  public inscription(joueur: any): Observable<any> {
    return this.httpJoueur.post(`${JoueurService.URL}/inscription`, joueur);
  }

  public loginExist(login: string): Observable<boolean> {
    //console.log(login);
    return this.httpJoueur.get<boolean>(`${JoueurService.URL}/login/${login}`);
  }
}
