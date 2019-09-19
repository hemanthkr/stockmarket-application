import { Component, OnInit } from '@angular/core';
import { Company } from 'src/app/models/company';
import { Sector } from 'src/app/models/sector';
import { StockExchange } from 'src/app/models/stock-exchange';
import { StockPrice } from 'src/app/models/stock-price';
import { Router } from '@angular/router';
import { CompanyService } from 'src/app/shared/services/company.service';
import { SectorService } from 'src/app/shared/services/sector.service';
import { StockExchangeService } from 'src/app/shared/services/stock-exchange.service';
import { StockpriceUploadService } from 'src/app/shared/services/stockprice-upload.service';
import { StockpriceService } from 'src/app/shared/services/stockprice.service';

@Component({
  selector: 'app-details',
  templateUrl: './details.component.html',
  styleUrls: ['./details.component.css']
})
export class DetailsComponent implements OnInit {

  // Misc data
  userId: number;
  companies: Company[] = [];
  sectors: Sector[] = [];
  stockExchanges: StockExchange[] = [];
  stockPrices: StockPrice[] = [];

  // Chart Data
  barChartOptions = {
    scaleShowVerticalLines: false,
    responsive: true
  };
  barChartLabels = [];
  barChartType = 'bar';
  barChartLegend = true;
  barChartData = [
    { data: [], label: '' }
  ];


  constructor(
    private router: Router, 
    private companyService: CompanyService, 
    private sectorService: SectorService, 
    private stockExchangeService: StockExchangeService, 
    private stockPriceService: StockpriceService,
    ) { }

  ngOnInit() {
    this.companyService.getCompanies().subscribe(async res => {
      this.companies = await res;
    });
    this.sectorService.getSectors().subscribe(async res => {
      this.sectors = await res;
    });
    this.stockExchangeService.getStockExhanges().subscribe(async res => {
      this.stockExchanges = await res;
    });
  }

  onClick1(companyId, stockExchangeId, periodicity) {
    let stockPrices;
    this.barChartLabels = [];
    this.barChartData = [];

    let x: string[] = [], y: number[] = [];

    this.stockPriceService.getStockPricesByCompanyId(companyId).subscribe(async res => {
      stockPrices = await res;
      for (let i = 0; i < stockPrices.length; i++) {
        x.push(stockPrices[i].time);
        y.push(stockPrices[i].currentPrice);
      }
    })

    this.barChartLabels = x;
    this.barChartData.push({ data: y, label: companyId });
  }

  
  onClick1Test(companyId, stockExchangeId, periodicity) {
    let stockPrices;
    this.barChartLabels = [];
    this.barChartData = [];
    let x: string[] = [], y: number[] = [];

    this.stockPriceService.getStockPricesCompare1(companyId,stockExchangeId, periodicity).subscribe(async res => {
      stockPrices = await res;
      for (let i = 0; i < stockPrices.length; i++) {
        x.push(stockPrices[i].time);
        y.push(stockPrices[i].currentPrice);
      }
    })

    this.barChartLabels = x;
    this.barChartData.push({ data: y, label: companyId });
  }

  onClick2(companyId1, companyId2, stockExchangeId, periodicity) {
    console.log(companyId1 + " " + companyId2)
    let stockPrices1: StockPrice[] = [];
    let stockPrices2: StockPrice[] = [];
    let x: string[] = [], y1: number[] = [], y2: number[] = [];
    this.barChartLabels = [];
    this.barChartData = [];



    this.stockPriceService.getStockPricesByCompanyId(companyId2).subscribe(async res => {
      stockPrices2 = await res;
      for (let i = 0; i < stockPrices2.length; i++) {
        x.push(stockPrices2[i].time);
        y1.push(stockPrices2[i].currentPrice);
      }
    })

    this.stockPriceService.getStockPricesByCompanyId(companyId1).subscribe(async res => {
      stockPrices1 = await res;
      for (let i = 0; i < stockPrices1.length; i++) {
        y2.push(stockPrices1[i].currentPrice);
      }
    })

    this.barChartLabels = x;
    this.barChartData = [
      { data: y1, label: companyId1 },
      { data: y2, label: companyId2 }
    ];

  }

  onClick3(sectorName, stockExchangeId, periodicity) {
    let stockPrices: any[] = [];
    this.barChartLabels = [];
    this.barChartData = [];
    let companies: Company[] = [];
    let x: string[][] = [], y: number[][] = [];

    this.companyService.getCompaniesBySectorName(sectorName).subscribe(async res => {
      companies = await res;
      for (let i = 0; i < companies.length; i++) {
        this.stockPriceService.getStockPricesByCompanyId(companies[i].id).subscribe(async res => {
          stockPrices[i] = await res;
        });
      }

    });
  }

  onClick4(value1, value2, value3, value4) {
    console.log(value1 + value2 + value3 + value4);
  }

  onClick5(value1, value2, value3, value4) {
    console.log(value1 + value2 + value3 + value4);
  }

}
