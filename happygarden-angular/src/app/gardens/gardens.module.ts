import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MyGardensComponent } from './my-gardens/my-gardens.component';
import { GardensRoutingModule } from './gardens-routing.module';

@NgModule({
  declarations: [MyGardensComponent],
  imports: [CommonModule, GardensRoutingModule]
})
export class GardensModule {}
