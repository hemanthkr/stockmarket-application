import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { HttpEvent, HttpRequest } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class StockpriceUploadService {

  baseUrl: String = 'http://localhost:8085';

  constructor(private http: HttpClient) { }

  pushFileToStorage(file: File, fileName: any): Observable<HttpEvent<{}>> {
    const formdata: FormData = new FormData();

    formdata.append('file', file, fileName);

    const req = new HttpRequest('POST', `${this.baseUrl}/post`, formdata, {
      reportProgress: true,
      responseType: 'text'
    });

    return this.http.request(req);
  }

  getFiles(): Observable<any> {
    return this.http.get(`${this.baseUrl}/getallfiles`);
  }

}
