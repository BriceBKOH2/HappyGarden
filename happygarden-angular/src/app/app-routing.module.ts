import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Routes, RouterModule } from '@angular/router';
import { environment } from 'src/environments/environment';
import { AuthenticateGuard } from './authenticate/guard/authenticate.guard';

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
    // canActivate: [AuthenticateGuard]
  },
  {
    path: 'login',
    loadChildren: './login/login.module#LoginModule'
  },
  {
    path: 'account',
    loadChildren: './account/account.module#AccountModule',
    canActivate: [AuthenticateGuard]
  }
];

@NgModule({
  declarations: [],
  imports: [
    RouterModule.forRoot(routes, {
      enableTracing: !environment.production, //Enable trace of routing and process in browser console
      paramsInheritanceStrategy: 'always' // Keep all data en params from url in routing
    }),
    CommonModule
  ],
  exports: [RouterModule]
})
export class AppRoutingModule {}
