import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LoginComponent } from './login.component';
import {MaterialModule} from '../material.module';

@NgModule({
  declarations: [LoginComponent],
  imports: [
    CommonModule
  ]
})
export class LoginModule { }
