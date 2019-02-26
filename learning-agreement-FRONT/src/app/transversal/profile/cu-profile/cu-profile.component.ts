import {Component, Input, OnInit} from '@angular/core';
import {User} from '../../User.model';
import {FormBuilder, Validators} from '@angular/forms';
import {Router} from '@angular/router';

@Component({
  selector: 'app-cu-profile',
  templateUrl: './cu-profile.component.html',
  styleUrls: ['./cu-profile.component.css']
})
export class CuProfileComponent implements OnInit {

  form;

  @Input() profile: User;
  constructor(private fb: FormBuilder, private router: Router) {

  }

  ngOnInit() {
    this.form = this.fb.group({
      lastName: [this.profile.lastName, [Validators.required]],
      firstName: [this.profile.firstName],
      birthDate: [this.profile.birthDate],
      mail: [this.profile.mail, [Validators.email]]
    });
  }

  save(): void {
console.table(this.form.value);
    this.router.navigateByUrl('/profile');
  }

}
