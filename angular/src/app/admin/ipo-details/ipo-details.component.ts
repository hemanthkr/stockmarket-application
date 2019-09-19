import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { IpoDetailService } from 'src/app/shared/services/ipo-detail.service';
import { Ipo } from 'src/app/models/ipo';

@Component({
  selector: 'app-ipo-details',
  templateUrl: './ipo-details.component.html',
  styleUrls: ['./ipo-details.component.css']
})
export class IpoDetailsComponent implements OnInit {

  userId: number;
  ipos: Ipo[];

  constructor(private router: Router, private ipoService: IpoDetailService) { }

  ngOnInit() {
    let userId = localStorage.getItem("userId");
    this.userId = parseInt(userId);
    if (!userId) {
      alert("Logged out of your account, Please Login again")
      this.router.navigate(['sign-in']);
      return;
    }
    this.ipoService.getIpos().subscribe(async res => {
      this.ipos = await res;
      console.log(this.ipos);
    })
  }

}
