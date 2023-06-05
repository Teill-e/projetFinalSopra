import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Unite } from '../models/unite';

@Injectable({
  providedIn: 'root',
})
export class UniteService {
  constructor(private httpClient: HttpClient) {}

  public getUnites(): Observable<Unite[]> {
    return this.httpClient.get<Unite[]>(
      'http://localhost:8080/armee/api/unite'
    );
  }

  public deleteById(id: number): Observable<void> {
    return this.httpClient.delete<void>(
      `http://localhost:8080/armee/api/unite/${id}`
    );
  }

  public create(unite: Unite): Observable<Unite> {
    return this.httpClient.post<Unite>(
      'http://localhost:8080/armee/api/unite',
      unite
    );
  }

  public getById(id: number): Observable<Unite> {
    return this.httpClient.get<Unite>(
      `http://localhost:8080/armee/api/unite/${id}`
    );
  }

  public update(unite: Unite): Observable<Unite> {
    return this.httpClient.put<Unite>(
      `http://localhost:8080/armee/api/unite/${unite.id}`,
      unite
    );
  }
}
