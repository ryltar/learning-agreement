import {Component, Input, OnInit} from '@angular/core';
import {User} from '../../User.model';
import {FormBuilder, Validators} from '@angular/forms';

@Component({
  selector: 'app-cu-profile',
  templateUrl: './cu-profile.component.html',
  styleUrls: ['./cu-profile.component.css']
})
export class CuProfileComponent implements OnInit {

  form;

  @Input() profile: User;
  constructor(private fb: FormBuilder) {

  }

  ngOnInit() {
    this.form = this.fb.group({
      lastName: [this.profile.lastName, [Validators.required, Validators.email]],
      firstName: [this.profile.firstName]
    });
  }

  save(): void {
console.table(this.form.value);
  }

}
