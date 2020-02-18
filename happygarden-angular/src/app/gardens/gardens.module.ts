import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MyGardensComponent } from './my-gardens/my-gardens.component';
import { GardensRoutingModule } from './gardens-routing.module';
import { MatCheckboxModule } from '@angular/material';
import { LibraryModule } from '../library/library.module';
import { GardenSidebarComponent } from './my-gardens/gardens-sidebar/garden-sidebar.component';
import { BodyPlantingAreaComponent } from './my-gardens/body-planting-area/body-planting-area.component';
import { BodyPlantComponent } from './my-gardens/body-plant/body-plant.component';

@NgModule({
  declarations: [MyGardensComponent, GardenSidebarComponent, BodyPlantingAreaComponent, BodyPlantComponent],
  imports: [
    CommonModule,
    GardensRoutingModule,
    MatCheckboxModule,
    LibraryModule
  ],
  exports: [GardenSidebarComponent]
})
export class GardensModule {}
