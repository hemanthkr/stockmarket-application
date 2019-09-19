import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Company } from 'src/app/models/company';

@Injectable({
  providedIn: 'root'
})
export class CompanyService {

  baseUrl = 'http://localhost:8085';
  
  constructor(private http: HttpClient) { }

  getCompanies(): Observable<any> {
    return this.http.get<any>(`${this.baseUrl}/company`);
  }

  addCompany(company: Company): Observable<any> {
    return this.http.post(`${this.baseUrl}/company`, company);
  }

  updateCompany(company: Company): Observable<any> {
    return this.http.post(`${this.baseUrl}/company/status`, company);
  }

  getCompanyById(companyId: number): Observable<Company> {
    return this.http.get<Company>(`${this.baseUrl}/company/${companyId}`);
  }

  getCompaniesBySectorName(sectorName: String): Observable<any> {
    return this.http.get<any>(`${this.baseUrl}/companies/${sectorName}`);
  }

}
