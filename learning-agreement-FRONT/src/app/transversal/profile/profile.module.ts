import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {ProfileComponent} from './profile.component';
import {MaterialModule} from '../../material.module';
import {CuProfileComponent} from './cu-profile/cu-profile.component';
import {ShowProfileComponent} from './show-profile/show-profile.component';

@NgModule({
  declarations: [
    ProfileComponent,
    CuProfileComponent,
    ShowProfileComponent
  ],
  imports: [
    CommonModule,
    MaterialModule
  ]
})
export class ProfileModule { }
