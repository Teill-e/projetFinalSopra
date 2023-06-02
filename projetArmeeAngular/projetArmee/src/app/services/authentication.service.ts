import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Compte } from '../models/compte';

@Injectable({
  providedIn: 'root',
})
export class AuthenticationService {
  private static URL: string = 'http://localhost:8080/armee/api/auth';
  constructor(private httpClient: HttpClient) {}

  public login(login: string, password: string): Observable<any> {
    let headers = new HttpHeaders({
      Authorization: 'Basic ' + btoa(login + ':' + password),
    });
    return this.httpClient.get(AuthenticationService.URL, {
      headers: headers,
    });
  }
  public isAdmin(): boolean {
    return this.checkRole('ROLE_ADMIN');
  }

  private checkRole(role: string): boolean {
    if (!this.isLogged()) {
      return false;
    }
    let compte: Compte = JSON.parse(
      sessionStorage.getItem('compte')!
    ) as Compte;
    return compte.role === role;
  }

  public isJoueur(): boolean {
    return this.checkRole('ROLE_JOUEUR');
  }

  public isLogged(): boolean {
    return sessionStorage.getItem('token') != null;
  }

  public disconnect() {
    sessionStorage.clear();
  }
}
