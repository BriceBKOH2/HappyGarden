import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CreateGardenComponent } from './create-garden/create-garden.component';
import { CreatePlantingAreaComponent } from './create-planting-area/create-planting-area.component';
import { CreatePlantComponent } from './create-plant/create-plant.component';

const routes: Routes = [
  { path: 'garden', component: CreateGardenComponent },
  { path: ':id/plantingArea', component: CreatePlantingAreaComponent },
  { path: ':id/plant', component: CreatePlantComponent }
  // { path: ':id', component: PlantSingleComponent }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CreateGardenRoutingModule {}
