import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MyGardensComponent } from './my-gardens/my-gardens.component';
import { GardensRoutingModule } from './gardens-routing.module';
import { MatCheckboxModule } from '@angular/material';
import { LibraryModule } from '../library/library.module';
import { GardenSidebarComponent } from './my-gardens/garden-sidebar/garden-sidebar.component';

@NgModule({
  declarations: [MyGardensComponent, GardenSidebarComponent],
  imports: [
    CommonModule,
    GardensRoutingModule,
    MatCheckboxModule,
    LibraryModule
  ],
  exports: [GardenSidebarComponent]
})
export class GardensModule {}
