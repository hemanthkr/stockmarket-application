import { Component, OnInit } from '@angular/core';
import { ProfileService } from '../shared/services/profile.service';
import { User } from '../models/user';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  users: User[];
  invalidLogin: boolean;
  username: String;
  password: String;

  constructor(private router: Router, private loginService: ProfileService) { }

  ngOnInit() {
    this.loginService.getUsers().subscribe(async res => {
      this.users = await res;
    }, error => alert(`${error.message}\nWaiting for response from server`))
  }

  checkLogin() {
    for (let i = 0; i < this.users.length; i++) {
      if (this.users[i].username === this.username && this.users[i].password === this.password) {
        if (this.users[i].userType === 'ADMIN') {
          this.router.navigate(['admin']);
        } else {
          this.router.navigate(['user']);
        }
        this.invalidLogin = false;
        localStorage.setItem("userId", this.users[i].id.toString());
      } else {
        this.invalidLogin = true;
      }
    }
  }

  onSubmit() {
    this.checkLogin();
  }
}
