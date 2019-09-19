import { Component, OnInit } from '@angular/core';
import { StockExchange } from 'src/app/models/stock-exchange';
import { Router } from '@angular/router';
import { StockExchangeService } from 'src/app/shared/services/stock-exchange.service';

@Component({
  selector: 'app-stockexchange-list',
  templateUrl: './stockexchange-list.component.html',
  styleUrls: ['./stockexchange-list.component.css']
})
export class StockexchangeListComponent implements OnInit {

  userId: number;
  stockExchanges: StockExchange[];

  constructor(private router: Router, private stockExchangeService: StockExchangeService) { }

  ngOnInit() {
    let userId = localStorage.getItem("userId");
    this.userId = parseInt(userId);
    if (!userId) {
      alert("Logged out of your account, Please Login again")
      this.router.navigate(['sign-in']);
      return;
    }
    this.stockExchangeService.getStockExhanges().subscribe( async res => {
      this.stockExchanges = res;
    })
  }

}
