import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AccountpageComponent } from './accountpage/accountpage.component';

const routes: Routes = [{ path: '', component: AccountpageComponent }];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AccountRoutingModule {}
