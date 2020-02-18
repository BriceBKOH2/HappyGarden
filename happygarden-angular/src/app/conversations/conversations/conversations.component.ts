import { Component, OnInit } from '@angular/core';
import { AuthenticateService } from 'src/app/authenticate/services/authenticate.service';
import { ConversationsService } from '../service/conversations.service';
import { Conversation } from 'src/app/classes/conversation';
import { Message } from 'src/app/classes/message';

@Component({
  selector: 'app-conversations',
  templateUrl: './conversations.component.html',
  styleUrls: ['./conversations.component.scss']
})
export class ConversationsComponent implements OnInit {
  constructor(
    public authServ: AuthenticateService,
    private convService: ConversationsService
  ) {}

  conversations: Conversation[] = [];
  conversation: Conversation;

  ngOnInit() {
    let id: number;
    this.authServ.user$.subscribe(response => {
      id = response.id;
      this.convService
        .getConversations(id)
        .subscribe(response => (this.conversations = response));
    });
  }
}
