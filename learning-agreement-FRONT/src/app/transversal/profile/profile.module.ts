import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {ProfileComponent} from './profile.component';
import {MaterialModule} from '../../material.module';
import {CuProfileComponent} from './cu-profile/cu-profile.component';
import {ShowProfileComponent} from './show-profile/show-profile.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';

@NgModule({
  declarations: [
    ProfileComponent,
    CuProfileComponent,
    ShowProfileComponent
  ],
  imports: [
    CommonModule,
    MaterialModule,
    FormsModule,
    ReactiveFormsModule
  ]
})
export class ProfileModule { }
