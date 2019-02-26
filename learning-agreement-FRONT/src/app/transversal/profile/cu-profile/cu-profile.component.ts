import {Component, Input, OnInit} from '@angular/core';
import {User} from '../../User.model';

@Component({
  selector: 'app-cu-profile',
  templateUrl: './cu-profile.component.html',
  styleUrls: ['./cu-profile.component.css']
})
export class CuProfileComponent implements OnInit {

  @Input() profile: User;
  constructor() { }

  ngOnInit() {
  }

}
