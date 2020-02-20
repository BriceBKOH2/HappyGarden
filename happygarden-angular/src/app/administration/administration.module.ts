import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AdminMenuComponent } from './admin-menu/admin-menu.component';
import { AdministrationRoutingModule } from './administration-routing.module';
import { UserManagementComponent } from './user-management/user-management.component';
import { UserDetailsComponent } from './user-details/user-details.component';
import { UserUpdateComponent } from './user-update/user-update.component';

import { FormsModule, ReactiveFormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AdminMenuComponent,
    UserManagementComponent,
    UserDetailsComponent,
    UserUpdateComponent
  ],
  imports: [CommonModule, AdministrationRoutingModule, FormsModule, ReactiveFormsModule]
})
export class AdministrationModule { }
