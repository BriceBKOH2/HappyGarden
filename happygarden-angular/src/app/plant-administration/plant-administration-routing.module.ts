import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { PlantApiComponent } from './plant-api/plant-api.component';

const routes: Routes = [{ path: '', component: PlantApiComponent }];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class PlantAdministrationRoutingModule {}
