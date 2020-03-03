import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Routes, RouterModule } from '@angular/router';
import { AuthenticateGuard } from './authenticate/guards/authenticate.guard';
import { AdminGuard } from './administration/guards/admin.guard';

const routes: Routes = [
  {
    path: '',
    redirectTo: 'homePage',
    pathMatch: 'full'
  },
  {
    path: 'error',
    loadChildren: './errorpages/errorpages.module#ErrorpagesModule'
  },
  {
    path: 'notloggedin',
    redirectTo: 'login;status=needlogin',
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
    path: 'gardens',
    loadChildren: './gardens/gardens.module#GardensModule'
    // canActivate: [AuthenticateGuard]
  },
  {
    path: 'login',
    loadChildren: './login/login.module#LoginModule'
  },
  {
    path: 'userAccount',
    loadChildren: './account/account.module#AccountModule',
    canActivate: [AuthenticateGuard]
  },
  {
    path: 'admin',
    loadChildren: './administration/administration.module#AdministrationModule',
    canActivate: [AuthenticateGuard, AdminGuard]
  },
  {
    path: 'userAccount/conversations',
    loadChildren: './conversations/conversations.module#ConversationsModule',
    canActivate: [AuthenticateGuard]
  },
  {
    path: 'userAccount/friends',
    loadChildren: './friends/friends.module#FriendsModule',
    canActivate: [AuthenticateGuard]
  }
];

@NgModule({
  declarations: [],
  imports: [
    RouterModule.forRoot(routes, {
      //  enableTracing: !environment.production, //Enable trace of routing and process in browser console
      // paramsInheritanceStrategy: 'always' // Keep all data en params from url in routing
    }),
    CommonModule
  ],
  exports: [RouterModule]
})
export class AppRoutingModule {}
