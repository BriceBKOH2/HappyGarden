import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { NotAuthorizedComponent } from './not-authorized/not-authorized.component';


const routes: Routes = [
  { path: 'notauthorized', component: NotAuthorizedComponent }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ErrorpagesRoutingModule { }
