import { Component, OnInit, Input } from '@angular/core';
import { User } from '../models/user';
import { Router } from '@angular/router';
import { ProfileService } from '../shared/services/profile.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  @Input()
  role: String;
  @Input()
  username: String;
  
  userId: number;
  user: User;

  constructor(private router: Router, private userService: ProfileService) { }

  ngOnInit() {
    console.log(this.role);
    let userId = localStorage.getItem("userId");
    this.userId = parseInt(userId);
    if (!userId) {
      alert("Logged out of your account, Please Login again")
      this.router.navigate(['sign-in']);
      return;
    }
    this.userService.getUserById(this.userId).subscribe(
      async res => {
        this.user = await res;
        this.username = this.user.username;
      }, error => console.log(error)
    )
  }

  logout(){
    localStorage.removeItem("userId");
    this.router.navigate(['sign-in']);
  }

}
