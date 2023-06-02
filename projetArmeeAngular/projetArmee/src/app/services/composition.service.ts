import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Composition } from '../models/composition';

@Injectable({
  providedIn: 'root',
})
export class CompositionService {
  constructor(private httpClient: HttpClient) {}

  public getCompositions(): Observable<Composition[]> {
    return this.httpClient.get<Composition[]>(
      'http://localhost:8080/armee/api/composition'
    );
  }

  public deleteById(id: number): Observable<void> {
    return this.httpClient.delete<void>(
      `http://localhost:8080/armee/api/composition/${id}`
    );
  }

  public create(composition: Composition): Observable<Composition> {
    return this.httpClient.post<Composition>(
      'http://localhost:8080/armee/api/composition',
      composition
    );
  }

  public getById(id: number): Observable<Composition> {
    return this.httpClient.get<Composition>(
      `http://localhost:8080/armee/api/composition/${id}`
    );
  }

  public update(composition: Composition): Observable<Composition> {
    return this.httpClient.put<Composition>(
      `http://localhost:8080/armee/api/composition/${composition.id}`,
      composition
    );
  }
}
