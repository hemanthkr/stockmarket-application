import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SectorService {

  baseUrl = 'http://localhost:8085';

  constructor(private http: HttpClient) { }

  getSectors(): Observable<any> {
    return this.http.get<any>(`${this.baseUrl}/sector`);
  }

}
