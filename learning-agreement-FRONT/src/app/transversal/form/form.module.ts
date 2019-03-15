import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {FormComponent} from './form.component';
import {MaterialModule} from '../../material.module';
import { ShowFormComponent } from './show-form/show-form.component';
import { CuFormComponent } from './cu-form/cu-form.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    FormComponent,
    ShowFormComponent,
    CuFormComponent
  ],
  imports: [
    CommonModule,
    MaterialModule,
    FormsModule,
    ReactiveFormsModule
  ]
})
export class FormModule { }