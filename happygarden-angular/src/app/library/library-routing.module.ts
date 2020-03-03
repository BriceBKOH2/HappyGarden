import { NgModule, Component } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LibraryListComponent } from './library-list/library-list.component';
import { PlantSingleComponent } from './plant-single/plant-single.component';
import { PlantUserComponent } from './plant-user/plant-user.component'

const routes: Routes = [
  { path: '', component: LibraryListComponent },
  { path: 'id/:id', component: PlantSingleComponent },
  { path: 'create', component: PlantUserComponent }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class LibraryRoutingModule {}
