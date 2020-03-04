import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CreateGardenComponent } from './create-garden/create-garden.component';
import { CreateGardenRoutingModule } from './create-garden-routing.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { CreatePlantingAreaComponent } from './create-planting-area/create-planting-area.component';
import { CreatePlantComponent } from './create-plant/create-plant.component';
import { MatRadioModule } from '@angular/material/radio';
import { LibraryModule } from '../library/library.module';
import { GardensModule } from '../gardens/gardens.module';
import { MatCheckboxModule } from '@angular/material';

@NgModule({
  declarations: [
    CreateGardenComponent,
    CreatePlantingAreaComponent,
    CreatePlantComponent
  ],
  exports: [CreateGardenComponent],
  imports: [
    CreateGardenRoutingModule,
    GardensModule,
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    MatRadioModule,
    LibraryModule,
    MatCheckboxModule
  ]
})
export class GardensCreateModule {}
