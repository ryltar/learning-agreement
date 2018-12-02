import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {UserListComponent} from './user-list.component';
import {AdminModule} from '../../admin/admin.module';
import {MaterialModule} from '../../material.module';

@NgModule({
  declarations: [
    UserListComponent
  ],
  imports: [
    CommonModule,
    MaterialModule
  ],
  exports: [UserListComponent]
})
export class UserListModule { }
