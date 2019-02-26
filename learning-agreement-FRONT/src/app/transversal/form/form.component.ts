import { Component, OnInit } from '@angular/core';
import {FormService} from './form.service';
import {Router} from '@angular/router';
import {User} from '../User.model';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.css']
})
export class FormComponent implements OnInit {

  constructor(private router: Router) {
  }
  ngOnInit(): void {
  }

}