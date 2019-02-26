import {MatButtonModule, MatCardModule, MatFormField, MatFormFieldModule, MatIconModule} from '@angular/material';
import {NgModule} from '@angular/core';

const modules = [
  MatCardModule,
  MatButtonModule,
  MatIconModule,
  MatFormFieldModule
];

@NgModule({
  imports: modules,
  exports: modules,
})
export class MaterialModule { }
