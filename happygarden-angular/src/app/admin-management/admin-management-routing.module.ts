import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { UserManagementComponent } from '../administration/user-management/user-management.component';
import { UserDetailsComponent } from '../administration/user-details/user-details.component';
import { UserUpdateComponent } from '../administration/user-update/user-update.component';

const routes: Routes = [
  { path: '', component: UserManagementComponent},
  { path: ':id', component: UserDetailsComponent },
  { path: 'update/:id', component: UserUpdateComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdminManagementRoutingModule { }
