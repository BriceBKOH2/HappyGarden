import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { UserManagementComponent } from './user-management/user-management.component';
import { UserSingleComponent } from './user-single/user-single.component';

const routes: Routes = [{ path: '', component: UserManagementComponent},
                         { path: ':id', component: UserSingleComponent }];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdminManagementRoutingModule { }
