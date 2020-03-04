import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { FriendsListComponent } from './friends-list/friends-list.component';
import { FriendComponent } from './friend/friend.component';

const routes: Routes = [
  { path: '', component: FriendsListComponent },
  { path: ':id', component: FriendComponent }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class FriendsRoutingModule {}
