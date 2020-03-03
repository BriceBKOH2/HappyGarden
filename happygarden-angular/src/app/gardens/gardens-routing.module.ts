import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { MyGardensComponent } from './my-gardens/my-gardens.component';
import { PlantSingleComponent } from '../library/plant-single/plant-single.component';

const routes: Routes = [
  { path: '', component: MyGardensComponent },
  { path: ':id', component: PlantSingleComponent }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class GardensRoutingModule {}
