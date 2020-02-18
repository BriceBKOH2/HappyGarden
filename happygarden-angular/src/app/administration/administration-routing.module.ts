import { NgModule } from '@angular/core';
import { AdminMenuComponent } from './admin-menu/admin-menu.component';
import { Routes, RouterModule } from '@angular/router';

const routes: Routes = [{ path: '', component: AdminMenuComponent }];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdministrationRoutingModule {}
