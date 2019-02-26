import { Injectable } from '@angular/core';
import {Router} from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private myRoute: Router) {
  }

  sendToken(token: string) {
    localStorage.setItem('LoggedInUser', token);
  }

  getToken() {
    return localStorage.getItem('LoggedInUser');
  }

  async isLoggedIn(): Promise<boolean> {
    // TODO
    /*
    A modifier -> call to api
     */
    console.log('getToken', this.getToken() !== null);
    return this.getToken() !== null;
  }

  logout() {
    console.log('in');
    localStorage.removeItem('LoggedInUser');
    this.myRoute.navigate(['login']);
  }
}

