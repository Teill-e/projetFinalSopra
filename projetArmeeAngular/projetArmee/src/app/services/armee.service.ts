import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Armee } from '../models/armee';

@Injectable({
  providedIn: 'root',
})
export class ArmeeService {
  constructor(private httpClient: HttpClient) {}

  public getArmees(): Observable<Armee[]> {
    return this.httpClient.get<Armee[]>(
      'http://localhost:8080/armee/api/armee'
    );
  }

  public deleteById(id: number): Observable<void> {
    return this.httpClient.delete<void>(
      `http://localhost:8080/armee/api/armee/${id}`
    );
  }

  public create(armee: Armee): Observable<Armee> {
    return this.httpClient.post<Armee>(
      'http://localhost:8080/armee/api/armee',
      armee
    );
  }

  public getById(id: number): Observable<Armee> {
    return this.httpClient.get<Armee>(
      `http://localhost:8080/armee/api/armee/${id}`
    );
  }

  public update(armee: Armee): Observable<Armee> {
    return this.httpClient.put<Armee>(
      `http://localhost:8080/armee/api/armee/${armee.id}`,
      armee
    );
  }
}
