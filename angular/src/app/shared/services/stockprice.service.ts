import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { StockPrice } from 'src/app/models/stock-price';

@Injectable({
  providedIn: 'root'
})
export class StockpriceService {

  baseUrl = 'http://localhost:8085';

  constructor(private http: HttpClient) { }

  getStockPrices(): Observable<any> {
    return this.http.get<any>(`${this.baseUrl}/stockprice`);
  }

  addStockPrice(stockPrice: StockPrice): Observable<any> {
    return this.http.post(`${this.baseUrl}/stockprice/create`, stockPrice);
  }

  updateStockPrice(stockPrice: StockPrice): Observable<any> {
    return this.http.post(`${this.baseUrl}/stockprice/create`, stockPrice);
  }

  getStockPriceById(stockPriceId: StockPrice): Observable<StockPrice> {
    return this.http.get<StockPrice>(`${this.baseUrl}/stockprice/${stockPriceId}`);
  }

  getStockPricesByCompanyId(companyId): Observable<any> {
    return this.http.get<any>(`${this.baseUrl}/stockprice/${companyId}`);
  }

  getStockPricesCompare1(companyId, stockExchangeId, periodicity): Observable<any> {
    return this.http.get<any>(`${this.baseUrl}/stockPrices/${companyId}/${stockExchangeId}/${periodicity}`);
  }
}
