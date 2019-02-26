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
import { ProfileComponent } from './transversal/profile/profile.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {TransversalModule} from './transversal/transversal.module';
import {MaterialModule} from './material.module';
import {ProfileService} from './transversal/profile/profile.service';
import { CuProfileComponent } from './transversal/profile/cu-profile/cu-profile.component';
import { ShowProfileComponent } from './transversal/profile/show-profile/show-profile.component';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    MainModule,
    LoginModule,
    AdminModule,
    RpiModule,
    StudentModule,
    UpModule,
    TransversalModule,
    MaterialModule
  ],
  providers: [ProfileService],
  bootstrap: [AppComponent]
})
export class AppModule { }