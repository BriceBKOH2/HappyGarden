import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AccountpageComponent } from './accountpage/accountpage.component';
import { AccountRoutingModule } from './account-routing.module';
import { SidebarAccountComponent } from './sidebar-account/sidebar-account.component';

@NgModule({
  declarations: [AccountpageComponent, SidebarAccountComponent],
  imports: [CommonModule, AccountRoutingModule],
  exports: [SidebarAccountComponent]
})
export class AccountModule {}
