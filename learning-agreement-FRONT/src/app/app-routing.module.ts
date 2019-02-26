import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import {MainComponent} from './main/main.component';
import {LoginComponent} from './login/login.component';
import {AdminComponent} from './admin/admin.component';
import {RpiComponent} from './rpi/rpi.component';
import {StudentComponent} from './student/student.component';
import {UpComponent} from './up/up.component';
import {ProfileComponent} from './transversal/profile/profile.component';
import {ShowProfileComponent} from './transversal/profile/show-profile/show-profile.component';
import { FormComponent } from './transversal/form/form.component';

const appRoutes: Routes = [
  { path: '', component: MainComponent },
  { path: 'login', component: LoginComponent },
  { path: 'admin', component: AdminComponent },
  { path: 'rpi', component: RpiComponent },
  { path: 'student', component: StudentComponent },
  { path: 'up', component: UpComponent },
  { path: 'profile', component: ProfileComponent},
  { path: 'profile/cuProfile', component: ProfileComponent},
  { path: 'form', component: FormComponent}

];

@NgModule({
  imports: [
    RouterModule.forRoot(
      appRoutes
    )
  ],
  exports: [
    RouterModule
  ]
})
export class AppRoutingModule {}
