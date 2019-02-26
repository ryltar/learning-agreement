import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {FormComponent} from './form.component';
import {MaterialModule} from '../../material.module';

@NgModule({
  declarations: [
    FormComponent
  ],
  imports: [
    CommonModule,
    MaterialModule
  ]
})
export class FormModule { }