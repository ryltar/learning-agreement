import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import {MainComponent} from './main/main.component';
import {LoginComponent} from './login/login.component';
import {AdminComponent} from './admin/admin.component';
import {RpiComponent} from './rpi/rpi.component';
import {StudentComponent} from './student/student.component';
import {UpComponent} from './up/up.component';
import {ProfileComponent} from './transversal/profile/profile.component';
import {AuthGuard} from './auth.guard';
import {AuthService} from './auth.service';
import {DashboardComponent} from './transversal/dashboard/dashboard.component';

const appRoutes: Routes = [
  { path: '', component: MainComponent , canActivate: [AuthGuard]},
  { path: 'login', component: LoginComponent },
  { path: 'up', component: UpComponent, canActivate: [AuthGuard]},
  { path: 'profile', component: ProfileComponent, canActivate: [AuthGuard]},
  { path: 'profile/cuProfile', component: ProfileComponent, canActivate: [AuthGuard]},
  { path: 'dashboard', component: DashboardComponent, canActivate: [AuthGuard]}
];

@NgModule({
  imports: [
    RouterModule.forRoot(
      appRoutes
    )
  ],
  exports: [
    RouterModule
  ],
  providers: [AuthService, AuthGuard]
})
export class AppRoutingModule {}
