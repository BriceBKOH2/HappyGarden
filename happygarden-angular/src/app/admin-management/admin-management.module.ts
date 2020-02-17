import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AdminManagementRoutingModule} from './admin-management-routing.module';
import { UserManagementComponent} from './user-management/user-management.component';
import { UserSingleComponent } from './user-single/user-single.component';


@NgModule({
  declarations: [UserManagementComponent, UserSingleComponent],
  imports: [CommonModule, AdminManagementRoutingModule,
    FormsModule,
    ReactiveFormsModule]
})
export class AdminManagementModule { }
