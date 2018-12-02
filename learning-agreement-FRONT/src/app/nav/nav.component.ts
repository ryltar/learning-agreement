import { Component, OnInit } from '@angular/core';
import {AuthService} from '../auth.service';
import {IUser} from '../transversal/User.model';

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.css']
})
export class NavComponent implements OnInit {

  isLoggedIn;
  user: IUser = JSON.parse(localStorage.getItem('user'));
  constructor(public auth: AuthService) { }
  async ngOnInit() {
    this.isLoggedIn = await this.auth.isLoggedIn();
    console.log(this.isLoggedIn);
  }
}
