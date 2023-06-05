import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class ArmeeAirService {
  private static URL: string = 'http://localhost:8080/armee/api/armee';
  constructor(private httpArmee: HttpClient) {}

  public creation(armee: any): Observable<any> {
    return this.httpArmee.post(`${ArmeeAirService.URL}`, armee);
  }
}
