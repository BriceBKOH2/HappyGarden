import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ConversationsComponent } from './conversations/conversations.component';
import { ConversationsRoutingModule } from './conversations-routing.module';
import { ConversationComponent } from './conversation/conversation.component';
import { SidebarAccountComponent } from '../account/sidebar-account/sidebar-account.component';
import { AccountModule } from '../account/account.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

@NgModule({
  declarations: [ConversationsComponent, ConversationComponent],
  imports: [
    CommonModule,
    ConversationsRoutingModule,
    AccountModule,
    FormsModule,
    ReactiveFormsModule
  ]
})
export class ConversationsModule {}
