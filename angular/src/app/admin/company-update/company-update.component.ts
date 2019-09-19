import { Component, OnInit } from '@angular/core';
import { Location } from '@angular/common';
import { Company } from 'src/app/models/company';
import { StockExchange } from 'src/app/models/stock-exchange';
import { Sector } from 'src/app/models/sector';
import { Router, ActivatedRoute } from '@angular/router';
import { CompanyService } from 'src/app/shared/services/company.service';
import { SectorService } from 'src/app/shared/services/sector.service';
import { StockExchangeService } from 'src/app/shared/services/stock-exchange.service';

@Component({
  selector: 'app-company-update',
  templateUrl: './company-update.component.html',
  styleUrls: ['./company-update.component.css']
})
export class CompanyUpdateComponent implements OnInit {

  userId: number;
  company: Company = new Company('','','','','','','');
  id: number;
  stockExchanges: StockExchange[];
  sectors: Sector[];

  constructor(private router: Router, private _location: Location, private companyService: CompanyService,
    private sectorService: SectorService, private stockExchangeService: StockExchangeService, private _route: ActivatedRoute) { }

  ngOnInit() {
    let userId = localStorage.getItem("userId");
    this.userId = parseInt(userId);
    if (!userId) {
      alert("Logged out of your account, Please Login again")
      this.router.navigate(['sign-in']);
      return;
    }

    this._route.params.subscribe(res => {
      this.id = Number.parseInt(res['id'])
      console.log(this.id);
    });

    this.companyService.getCompanyById(this.id).subscribe(async res => {
      this.company = await res;
      console.log(this.company);
    })

    this.sectorService.getSectors().subscribe(async res => {
      this.sectors = await res;
      console.log(this.sectors);
    });

    this.stockExchangeService.getStockExhanges().subscribe(async res => {
      this.stockExchanges = await res;
      console.log(this.stockExchanges);
    });
  }

  onSubmit() {
    console.log(this.company);
    this.companyService.updateCompany(this.company).subscribe(
      async res => {
        this.company = await res;
        console.log(this.company);
        this.router.navigate(['admin/list-company']);
      },
      error => console.log(error)
    );
  }

  backClicked() {
    this._location.back();
  }
}
