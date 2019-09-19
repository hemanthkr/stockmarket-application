import { Component, OnInit } from '@angular/core';
import { Location } from '@angular/common';

@Component({
  selector: 'app-add-stockexchange',
  templateUrl: './add-stockexchange.component.html',
  styleUrls: ['./add-stockexchange.component.css']
})
export class AddStockexchangeComponent implements OnInit {

  constructor(private _location: Location) { }

  ngOnInit() {
  }

  backClicked() {
    this._location.back();
  }
}
