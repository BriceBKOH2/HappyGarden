import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MyGardensComponent } from './my-gardens/my-gardens.component';
import { GardensRoutingModule } from './gardens-routing.module';
import { MatCheckboxModule } from '@angular/material';
import { LibraryModule } from '../library/library.module';
import { GardenSidebarComponent } from './my-gardens/gardens-sidebar/garden-sidebar.component';
import { BodyPlantingAreaComponent } from './my-gardens/body-planting-area/body-planting-area.component';
import { BodyPlantComponent } from './my-gardens/body-plant/body-plant.component';
import { BodyGardenComponent } from './my-gardens/body-garden/body-garden.component';
import { FileModule } from '../file/file.module';
import { ReminderEditComponent } from '../reminders/reminder-edit/reminder-edit.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    MyGardensComponent,
    GardenSidebarComponent,
    BodyPlantingAreaComponent,
    BodyPlantComponent,
    BodyGardenComponent,
    ReminderEditComponent,
  ],
  imports: [
    CommonModule,
    GardensRoutingModule,
    MatCheckboxModule,
    LibraryModule,
    FileModule,
    FormsModule, ReactiveFormsModule
  ],
  exports: [GardenSidebarComponent]
})
export class GardensModule {}
