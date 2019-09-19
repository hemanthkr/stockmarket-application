import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from 'src/app/models/user';

@Injectable({
  providedIn: 'root'
})
export class ProfileService {

  baseUrl = 'http://localhost:8090';
  
  constructor(private http: HttpClient) { }

  getUsers(): Observable<any> {
    return this.http.get<any>(`${this.baseUrl}/profile`);
  }

  registerUser(user: User): Observable<any> {
    return this.http.post(`${this.baseUrl}/user/create`, user);
  }

  updateUser(user: User): Observable<any> {
    return this.http.post(`${this.baseUrl}/user/create`, user);
  }

  getUserById(userId: number): Observable<User> {
    return this.http.get<User>(`${this.baseUrl}/user/${userId}`);
  }

}
