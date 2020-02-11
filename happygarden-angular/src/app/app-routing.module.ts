import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Routes, RouterModule } from '@angular/router';
import { AuthGuard } from './authenticate/auth/guards/auth.guard';

const routes: Routes = [
  {
    path: '',
    redirectTo: 'homePage',
    pathMatch: 'full'
  },
  {
    path: 'homePage',
    loadChildren: './home/home.module#HomeModule'
  },
  {
    path: 'libraryList',
    loadChildren: './library/library.module#LibraryModule'
  },
  {
    path: 'gardenList',
    loadChildren: './gardens/gardens.module#GardensModule'
    // canActivate: [AuthGuard]
  }
];

@NgModule({
  declarations: [],
  imports: [RouterModule.forRoot(routes), CommonModule],
  exports: [RouterModule]
})
export class AppRoutingModule {}
