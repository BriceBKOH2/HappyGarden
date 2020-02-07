import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LibraryListComponent } from './library-list/library-list.component';
import { PlantSingleComponent } from './plant-single/plant-single.component';

const routes: Routes = [
  { path: '', component: LibraryListComponent },
  { path: '', component: PlantSingleComponent }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class LibraryRoutingModule {}
