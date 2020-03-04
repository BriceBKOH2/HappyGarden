import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { LibraryRoutingModule } from './library-routing.module';
import { LibraryListComponent } from './library-list/library-list.component';
import { PlantSingleComponent } from './plant-single/plant-single.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { PlantUserComponent } from './plant-user/plant-user.component';

@NgModule({
  declarations: [
    LibraryListComponent,
    PlantSingleComponent,
    PlantUserComponent
  ],
  imports: [
    CommonModule,
    LibraryRoutingModule,
    FormsModule,
    ReactiveFormsModule
  ],
  exports: [PlantSingleComponent, LibraryListComponent]
})
export class LibraryModule {}
