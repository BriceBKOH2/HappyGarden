import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CreateGardenComponent } from './create-garden/create-garden.component';
import { CreateGardenRoutingModule } from './create-garden-routing.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

@NgModule({
  declarations: [CreateGardenComponent],
  exports: [CreateGardenComponent],
  imports: [
    CreateGardenRoutingModule,
    CommonModule,
    FormsModule,
    ReactiveFormsModule
  ]
})
export class GardensCreateModule {}
