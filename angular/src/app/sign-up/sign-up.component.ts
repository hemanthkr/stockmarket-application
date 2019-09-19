import { Component, OnInit } from '@angular/core';
import { User } from '../models/user';
import { Router } from '@angular/router';
import { ProfileService } from '../shared/services/profile.service';

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css']
})
export class SignUpComponent implements OnInit {

  username: String;
  password: String;
  email: String;
  mobile: String;
  user: User;

  constructor(private router: Router,private userService: ProfileService) { }

  ngOnInit() {
  }

  onSubmit() {
    this.userService.registerUser(new User(this.username, this.password, this.email, "USER", this.mobile)).subscribe(
      async res => { 
        this.user = await res;
        this.router.navigate(['sign-in'])
       },
      error => console.log(error)
    );
  }
}
