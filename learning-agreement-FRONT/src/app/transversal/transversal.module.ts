import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {ProfileModule} from './profile/profile.module';
import {MaterialModule} from '../material.module';
import {CuProfileComponent} from './profile/cu-profile/cu-profile.component';
import {ShowProfileComponent} from './profile/show-profile/show-profile.component';
import {FormModule} from './form/form.module';
import { UserListComponent } from './user-list/user-list.component';
import {UserListModule} from './user-list/user-list.module';
import { DashboardComponent } from './dashboard/dashboard.component';
import {DashboardModule} from './dashboard/dashboard.module';
import {AdminComponent} from '../admin/admin.component';
import {AdminModule} from '../admin/admin.module';

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    ProfileModule,
    FormModule,
    UserListModule,
    DashboardModule
  ]
})
export class TransversalModule { }
