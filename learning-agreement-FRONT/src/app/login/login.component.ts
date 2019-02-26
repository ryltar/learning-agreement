import {Component, OnInit} from '@angular/core';
import {ProfileService} from '../transversal/profile/profile.service';
import {Subject} from 'rxjs';
import {Router} from '@angular/router';
import {User} from '../transversal/User.model';
import {AuthService} from '../auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  login: string;
  mdp: string;
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

  /*
    constructor() {

    }*/


  constructor(private myRoute: Router,
              private auth: AuthService) {
  }

  ngOnInit() {
  }

  go() {
    this.auth.sendToken('token');

    if(this.login == 'martin'){
      localStorage.setItem('user', JSON.stringify(new User(
        1,
        1,
        'Martin',
        'admin',
        'Guillaume',
        '1997-03-21',
        'guillaume.martin@lacatholille.fr',
        'https://images.ecosia.org/5Qjv8mGEUR2h5gFCkSirrIWrTpE=/0x390/smart/http%3A%2F%2Fupload.wikimedia.org%2Fwikipedia%2Fcommons%2F3%2F3a%2FJon_Kirsch%27s_Signature.png',
        ''
      )));

    }

    if(this.login == 'longuet'){
      localStorage.setItem('user', JSON.stringify(new User(
        1,
        1,
        'Longuet',
        'rpi',
        'Vivien',
        '1995-09-28',
        'vivien.longuet@lacatholille.fr',
        'https://images.ecosia.org/5Qjv8mGEUR2h5gFCkSirrIWrTpE=/0x390/smart/http%3A%2F%2Fupload.wikimedia.org%2Fwikipedia%2Fcommons%2F3%2F3a%2FJon_Kirsch%27s_Signature.png',
        ''
      )));
    }

    else {
      localStorage.setItem('user', JSON.stringify(new User(
        1,
        1,
        'Gense',
        'student',
        'Jimmy',
        '1996-01-01',
        'jimmy.gense@lacatholille.fr',
        'https://images.ecosia.org/5Qjv8mGEUR2h5gFCkSirrIWrTpE=/0x390/smart/http%3A%2F%2Fupload.wikimedia.org%2Fwikipedia%2Fcommons%2F3%2F3a%2FJon_Kirsch%27s_Signature.png',
        ''
      )));
    }

    this.myRoute.navigateByUrl('');
  }
}
