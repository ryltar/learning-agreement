import {
  MatButtonModule,
  MatCardModule,
  MatFormField,
  MatFormFieldModule,
  MatIconModule,
  MatInputModule, MatPaginatorModule, MatSortModule,
  MatTableModule,
  MatToolbarModule
} from '@angular/material';
import {NgModule} from '@angular/core';
import {FormGroup, FormsModule} from '@angular/forms';

const modules = [
  MatCardModule,
  MatButtonModule,
  MatIconModule,
  MatFormFieldModule,
  MatInputModule,
  MatTableModule,
  MatPaginatorModule,
  MatSortModule,
  MatToolbarModule
];

@NgModule({
  imports: modules,
  exports: modules,
})
export class MaterialModule { }
