import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Compte } from '../models/compte';

@Injectable({
  providedIn: 'root',
})
export class CompteService {
  constructor(private httpClient: HttpClient) {}

  public getComptes(): Observable<Compte[]> {
    return this.httpClient.get<Compte[]>(
      'http://localhost:8080/armee/api/compte'
    );
  }

  public deleteById(id: number): Observable<void> {
    return this.httpClient.delete<void>(
      `http://localhost:8080/armee/api/compte/${id}`
    );
  }

  public create(compte: Compte): Observable<Compte> {
    return this.httpClient.post<Compte>(
      'http://localhost:8080/armee/api/compte',
      compte
    );
  }

  public getById(id: number): Observable<Compte> {
    return this.httpClient.get<Compte>(
      `http://localhost:8080/armee/api/compte/${id}`
    );
  }

  public update(compte: Compte): Observable<Compte> {
    return this.httpClient.put<Compte>(
      `http://localhost:8080/armee/api/compte/${compte.id}`,
      compte
    );
  }
}
