import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FriendsListComponent } from './friends-list/friends-list.component';
import { FriendsRoutingModule } from './friends-routing.module';
import { AccountModule } from '../account/account.module';
import { FriendComponent } from './friend/friend.component';

@NgModule({
  declarations: [FriendsListComponent, FriendComponent],
  imports: [CommonModule, FriendsRoutingModule, AccountModule]
})
export class FriendsModule {}
