import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { MyGardensComponent } from './my-gardens/my-gardens.component';

const routes: Routes = [{ path: '', component: MyGardensComponent }];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class GardensRoutingModule {}
