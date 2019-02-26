import { Component, OnInit } from '@angular/core';
import {MatTableDataSource} from '@angular/material';
import {IUsePropertyDecoratorConfig} from 'codelyzer/propertyDecoratorBase';
import {IUser, User} from '../User.model';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  account: string = JSON.parse(localStorage.getItem('user')).role;
  dataSource: MatTableDataSource<IUser>;

  constructor() {
    this.dataSource = new MatTableDataSource([new User(
      1,
      1,
      'Martin',
      'admin',
      'Guillaume',
      '1997-03-21',
      'guillaume.martin@lacatholille.fr',
      'https://images.ecosia.org/5Qjv8mGEUR2h5gFCkSirrIWrTpE=/0x390/smart/http%3A%2F%2Fupload.wikimedia.org%2Fwikipedia%2Fcommons%2F3%2F3a%2FJon_Kirsch%27s_Signature.png',
      ''
    )]);
  }

  ngOnInit() {
  }

}
