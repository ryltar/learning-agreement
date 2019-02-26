import {Component, OnInit} from '@angular/core';
import {ProfileService} from '../transversal/profile/profile.service';
import {Subject} from 'rxjs';
import {Router} from '@angular/router';
import {User} from '../transversal/User.model';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  /*constructor(
    private profileService: ProfileService,
    private router: Router) {
  }

  newUser() {
    this.profileService.user = new User(
      1,
      1,
      'Martin',
      'Guillaume',
      new Date('1997-03-21'),
      'guillaume.martin@lacatholille.fr',
      '', '');

  }

  ngOnInit(): void {
    this.newUser();
    this.router.navigateByUrl('/profile');
  }*/

  constructor() {
    localStorage.setItem('user', JSON.stringify(new User(
      1,
      1,
      'Martin',
      'Guillaume',
      new Date('1997-03-21'),
      'guillaume.martin@lacatholille.fr',
      'https://images.ecosia.org/5Qjv8mGEUR2h5gFCkSirrIWrTpE=/0x390/smart/http%3A%2F%2Fupload.wikimedia.org%2Fwikipedia%2Fcommons%2F3%2F3a%2FJon_Kirsch%27s_Signature.png',
      '')));
  }

  ngOnInit() {}
}
