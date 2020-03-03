import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ErrorpagesRoutingModule } from './errorpages-routing.module';
import { NotAuthorizedComponent } from './not-authorized/not-authorized.component';


@NgModule({
  declarations: [NotAuthorizedComponent],
  imports: [
    CommonModule,
    ErrorpagesRoutingModule
  ]
})
export class ErrorpagesModule { }
