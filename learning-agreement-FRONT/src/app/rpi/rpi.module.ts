import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RpiComponent } from './rpi.component';

@NgModule({
  declarations: [RpiComponent],
  imports: [
    CommonModule
  ],
  exports: [RpiComponent]
})
export class RpiModule { }
