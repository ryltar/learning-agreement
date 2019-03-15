import {Component, Input, OnInit} from '@angular/core';
import {Router, UrlSerializer} from '@angular/router';
import { Form } from '../../Form.model';

@Component({
  selector: 'app-show-form',
  templateUrl: './show-form.component.html',
  styleUrls: ['./show-form.component.css']
})
export class ShowFormComponent implements OnInit {

    showForm: Form = JSON.parse(localStorage.getItem('form'));
    
    constructor() {      
  }

  ngOnInit() {
    console.dir(this.showForm);
  }

}
