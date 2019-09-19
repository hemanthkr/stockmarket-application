import { Component, OnInit } from '@angular/core';
import { Ipo } from 'src/app/models/ipo';
import { StockExchange } from 'src/app/models/stock-exchange';
import { Router, ActivatedRoute } from '@angular/router';
import { StockExchangeService } from 'src/app/shared/services/stock-exchange.service';
import { IpoDetailService } from 'src/app/shared/services/ipo-detail.service';
import { Location } from '@angular/common';

@Component({
  selector: 'app-ipo-revise',
  templateUrl: './ipo-revise.component.html',
  styleUrls: ['./ipo-revise.component.css']
})
export class IpoReviseComponent implements OnInit {

  userId: number;
  ipo: Ipo = new Ipo('', '', '', '', '');
  id: number;
  stockExchanges: StockExchange[];
  constructor(private router: Router, private ipoService: IpoDetailService, private _route: ActivatedRoute, private stockExchangeService: StockExchangeService, private _location: Location) { }

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

    this.ipoService.getIpoById(this.id).subscribe(async res => {
      this.ipo = await res;
    });

    this.stockExchangeService.getStockExhanges().subscribe(async res => {
      this.stockExchanges = await res;
      console.log(this.stockExchanges);
    });
  }
  onSubmit() {
    console.log(this.ipo.id)
    this.ipoService.updateIpo(this.ipo).subscribe(
      async res => {
        this.ipo = await res;
        console.log(this.ipo);
        this.router.navigate(['admin/list-ipo']);
      },
      error => console.log(error)
    );
  }

  backClicked() {
    this._location.back();
  }

}
