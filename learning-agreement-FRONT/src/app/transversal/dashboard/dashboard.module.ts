import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {DashboardComponent} from './dashboard.component';
import {AdminModule} from '../../admin/admin.module';
import {RpiModule} from '../../rpi/rpi.module';
import {StudentModule} from '../../student/student.module';
import {MaterialModule} from '../../material.module';
import {UserListModule} from '../user-list/user-list.module';

@NgModule({
  declarations: [
    DashboardComponent
  ],
  imports: [
    CommonModule,
    AdminModule,
    RpiModule,
    StudentModule,
    MaterialModule,
    UserListModule
  ]
})
export class DashboardModule { }
