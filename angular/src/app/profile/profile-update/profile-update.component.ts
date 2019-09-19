import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/models/user';
import { Router } from '@angular/router';
import { ProfileService } from 'src/app/shared/services/profile.service';

@Component({
  selector: 'app-profile-update',
  templateUrl: './profile-update.component.html',
  styleUrls: ['./profile-update.component.css']
})
export class ProfileUpdateComponent implements OnInit {

  userId: number;
  user: User = new User('', '' ,'' ,'' ,'');

  constructor(private router: Router, private userService: ProfileService) { }

  ngOnInit() {
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
      }, error => console.log(error)
    )
  }

  onSubmit() {
    this.userService.registerUser(new User(this.user.username, this.user.password, this.user.email, "USER", this.user.mobile, this.userId)).subscribe(
      async res => { 
        this.user = await res;
        this.router.navigate(['user/details'])
       },
      error => console.log(error)
    );
  }


}
