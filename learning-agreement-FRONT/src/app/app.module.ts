import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import {AppRoutingModule} from './app-routing.module';
import {MainModule} from './main/main.module';
import {LoginModule} from './login/login.module';
import {AdminModule} from './admin/admin.module';
import {StudentModule} from './student/student.module';
import {UpModule} from './up/up.module';
import {RpiModule} from './rpi/rpi.module';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MainModule,
    LoginModule,
    AdminModule,
    RpiModule,
    StudentModule,
    UpModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
