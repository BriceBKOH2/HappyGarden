import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AdminManagementRoutingModule} from './admin-management-routing.module';
import { UserManagementComponent} from './user-management/user-management.component';


@NgModule({
  declarations: [UserManagementComponent],
  imports: [CommonModule, AdminManagementRoutingModule]
})
export class AdminManagementModule { }
