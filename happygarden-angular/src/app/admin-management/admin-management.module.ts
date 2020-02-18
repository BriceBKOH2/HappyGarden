import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AdminManagementRoutingModule} from './admin-management-routing.module';
import { UserManagementComponent} from './user-management/user-management.component';
import { UserDetailsComponent } from './user-details/user-details.component';
import { UserUpdateComponent } from './user-update/user-update.component';


@NgModule({
  declarations: [UserManagementComponent, UserDetailsComponent, UserUpdateComponent],
  imports: [CommonModule, AdminManagementRoutingModule,
    FormsModule,
    ReactiveFormsModule]
})
export class AdminManagementModule { }
