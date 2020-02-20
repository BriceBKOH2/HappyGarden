import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CreateGardenComponent } from './create-garden/create-garden.component';

const routes: Routes = [
  { path: 'garden', component: CreateGardenComponent }
  // { path: ':id', component: PlantSingleComponent }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CreateGardenRoutingModule {}
