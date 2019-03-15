import {Component, Input, OnInit} from '@angular/core';
import {FormBuilder, Validators} from '@angular/forms';
import { Form } from '../../Form.model';

@Component({
  selector: 'app-cu-form',
  templateUrl: './cu-form.component.html',
  styleUrls: ['./cu-form.component.css']
})
export class CuFormComponent implements OnInit {

    form;
    modForm: Form = JSON.parse(localStorage.getItem('form'));
  
  constructor(private fb: FormBuilder) {

  }

  ngOnInit() {
    this.form = this.fb.group({
      schoolYearStart: [this.modForm.schoolYearStart],
      schoolYearEnd: [this.modForm.schoolYearEnd],
      semester: [this.modForm.semester],
      signatureDate: [this.modForm.signatureDate],
      rpi: [this.modForm.rpi.lastName],
      partner: [this.modForm.partner.lastName]
    });
  }

  save(): void {
console.table(this.form.value);
  }

}
