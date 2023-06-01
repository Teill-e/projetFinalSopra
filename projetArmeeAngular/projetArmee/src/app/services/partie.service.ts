import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Partie } from '../models/partie';

@Injectable({
  providedIn: 'root',
})
export class PartieService {
  constructor(private httpClient: HttpClient) {}

  public getParties(): Observable<Partie[]> {
    return this.httpClient.get<Partie[]>(
      'http://localhost:8080/armee/api/partie'
    );
  }

  public deleteById(id: number): Observable<void> {
    return this.httpClient.delete<void>(
      `http://localhost:8080/armee/api/partie/${id}`
    );
  }

  public create(partie: Partie): Observable<Partie> {
    return this.httpClient.post<Partie>(
      'http://localhost:8080/armee/api/partie',
      partie
    );
  }

  public getById(id: number): Observable<Partie> {
    return this.httpClient.get<Partie>(
      `http://localhost:8080/armee/api/partie/${id}`
    );
  }

  public update(partie: Partie): Observable<Partie> {
    return this.httpClient.put<Partie>(
      `http://localhost:8080/armee/api/partie/${partie.id}`,
      partie
    );
  }
}
