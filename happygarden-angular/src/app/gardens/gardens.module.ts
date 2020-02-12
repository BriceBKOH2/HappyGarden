import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MyGardensComponent } from './my-gardens/my-gardens.component';
import { GardensRoutingModule } from './gardens-routing.module';
import { MatCheckboxModule } from '@angular/material';

@NgModule({
  declarations: [MyGardensComponent],
  imports: [CommonModule, GardensRoutingModule, MatCheckboxModule]
})
export class GardensModule {}
