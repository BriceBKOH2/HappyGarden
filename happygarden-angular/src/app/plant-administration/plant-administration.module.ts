import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { PlantAdministrationRoutingModule } from './plant-administration-routing.module';
import { PlantApiComponent } from './plant-api/plant-api.component';

@NgModule({
  declarations: [PlantApiComponent],
  imports: [CommonModule, PlantAdministrationRoutingModule]
})
export class PlantAdministrationModule {}
