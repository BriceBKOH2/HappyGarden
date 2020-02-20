import { NgModule } from '@angular/core';
import { AdminMenuComponent } from './admin-menu/admin-menu.component';
import { Routes, RouterModule } from '@angular/router';
import { UserManagementComponent } from './user-management/user-management.component';
import { UserDetailsComponent } from './user-details/user-details.component';
import { UserUpdateComponent } from './user-update/user-update.component';

const routes: Routes = [
  { path: '', component: AdminMenuComponent },
  { path: 'usermanagement', component: UserManagementComponent },
  { path: 'usermanagement/:id', component: UserDetailsComponent },
  { path: 'usermanagement/update/:id', component: UserUpdateComponent }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdministrationRoutingModule {}
