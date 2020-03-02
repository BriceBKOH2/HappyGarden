import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CreateGardenComponent } from './create-garden/create-garden.component';
import { CreateGardenRoutingModule } from './create-garden-routing.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { CreatePlantingAreaComponent } from './create-planting-area/create-planting-area.component';
import { CreatePlantComponent } from './create-plant/create-plant.component';
import { MatRadioModule } from '@angular/material/radio';

@NgModule({
  declarations: [
    CreateGardenComponent,
    CreatePlantingAreaComponent,
    CreatePlantComponent
  ],
  exports: [CreateGardenComponent],
  imports: [
    CreateGardenRoutingModule,
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    MatRadioModule
  ]
})
export class GardensCreateModule {}
