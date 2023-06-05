import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Arme } from '../models/arme';

@Injectable({
  providedIn: 'root',
})
export class ArmeService {
  constructor(private httpClient: HttpClient) {}

  public getArmes(): Observable<Arme[]> {
    return this.httpClient.get<Arme[]>('http://localhost:8080/armee/api/arme');
  }

  public deleteById(id: number): Observable<void> {
    return this.httpClient.delete<void>(
      `http://localhost:8080/armee/api/arme/${id}`
    );
  }

  public create(arme: Arme): Observable<Arme> {
    return this.httpClient.post<Arme>(
      'http://localhost:8080/armee/api/arme',
      arme
    );
  }

  public getById(id: number): Observable<Arme> {
    return this.httpClient.get<Arme>(
      `http://localhost:8080/armee/api/arme/${id}`
    );
  }

  public update(arme: Arme): Observable<Arme> {
    return this.httpClient.put<Arme>(
      `http://localhost:8080/armee/api/arme/${arme.id}`,
      arme
    );
  }
}
