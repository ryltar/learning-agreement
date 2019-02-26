import { Component, OnInit } from '@angular/core';
import {ProfileService} from './profile.service';
import {Router} from '@angular/router';
import {User} from '../User.model';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  /*profile: User = this.profileService.user;

  constructor(
    private profileService: ProfileService) {}
*/

  profile: User = JSON.parse(localStorage.getItem('user'));
  crudProfile = this.router.url === '/profile/cuProfile';

  constructor(private router: Router) {
  }
  ngOnInit(): void {
  }

}
