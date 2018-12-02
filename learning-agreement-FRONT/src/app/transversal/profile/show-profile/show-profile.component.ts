import {Component, Input, OnInit} from '@angular/core';
import {Router, UrlSerializer} from '@angular/router';
import {User} from '../../User.model';

@Component({
  selector: 'app-show-profile',
  templateUrl: './show-profile.component.html',
  styleUrls: ['./show-profile.component.css']
})
export class ShowProfileComponent implements OnInit {

  @Input() profile: User;

  constructor(private router: Router) {console.table(this.profile) }

  ngOnInit() {
  }

}
