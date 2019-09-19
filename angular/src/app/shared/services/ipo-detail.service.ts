import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Ipo } from 'src/app/models/ipo';

@Injectable({
  providedIn: 'root'
})
export class IpoDetailService {

  baseUrl = 'http://localhost:8085';

  constructor(private http: HttpClient) { }

  getIpos(): Observable<any> {
    return this.http.get<any>(`${this.baseUrl}/ipo`);
  }

  addIpo(ipo: Ipo): Observable<any> {
    return this.http.post(`${this.baseUrl}/ipo/create`, ipo);
  }

  updateIpo(ipo: Ipo): Observable<any> {
    return this.http.post(`${this.baseUrl}/ipo/create`, ipo);
  }

  getIpoById(ipoId: number): Observable<Ipo> {
    return this.http.get<Ipo>(`${this.baseUrl}/ipo/${ipoId}`);
  }

}
