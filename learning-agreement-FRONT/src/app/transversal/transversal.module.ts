import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {ProfileModule} from './profile/profile.module';
import {MaterialModule} from '../material.module';
import {CuProfileComponent} from './profile/cu-profile/cu-profile.component';
import {ShowProfileComponent} from './profile/show-profile/show-profile.component';
import {FormModule} from './form/form.module';

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    ProfileModule,
    FormModule
  ]
})
export class TransversalModule { }
