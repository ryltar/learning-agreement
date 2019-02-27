import { Component, OnInit } from '@angular/core';
import {FormService} from './form.service';
import {Router} from '@angular/router';
import {User} from '../User.model';
import { MatTableDataSource } from '@angular/material';
import { IForm, Form } from '../Form.model';
import { Course } from '../Course.model';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.css']
})
export class FormComponent implements OnInit {

  displayedColumns: string[] = ['ID','Start date','End date','Semester','Actions'];

  datasource: MatTableDataSource<IForm>;
  listCourses: Array<Course> = [
    new Course(1,'Maths', 3, 3),
    new Course(1,'IT', 3, 3)
  ]
  constructor(private router: Router) {
    this.datasource = new MatTableDataSource([new Form(
      1,
      2019,
      2020,
      1,
      new Date(),
      JSON.parse(localStorage.getItem('user')),
      JSON.parse(localStorage.getItem('user')),
      this.listCourses
    )]);

    console.dir(this.datasource);
  }
  ngOnInit() {
  }

  showForm(row: Form) {
    localStorage.setItem('form',JSON.stringify(row));
    this.router.navigateByUrl('/form/show');
  }

  cuForm(row: Form) {
    localStorage.setItem('form', JSON.stringify(row));
    this.router.navigateByUrl('/form/cuForm');
  }
}