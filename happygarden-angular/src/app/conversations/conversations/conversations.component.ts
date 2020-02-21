import { Component, OnInit } from '@angular/core';
import { AuthenticateService } from 'src/app/authenticate/services/authenticate.service';
import { ConversationsService } from '../service/conversations.service';
import { Conversation } from 'src/app/classes/conversation';
import { Message } from 'src/app/classes/message';
import { switchMap, map, tap } from 'rxjs/operators';
import { Observable, forkJoin } from 'rxjs';

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

  conversations$: Observable<Conversation[]>;
  nbMessages: number;

  ngOnInit() {
    let id: number;
    this.conversations$ = this.authServ.user$.pipe(
      switchMap(user => {
        return this.convService.getConversations(user.id);
      }),
      switchMap(conversations => {
        const conversationAvecNbMessage: Observable<any>[] = [];
        conversations.forEach(conv => {
          conversationAvecNbMessage.push(
            this.convService.countMessages(conv.id).pipe(
              map(nbrMessage => {
                conv.nbMessages = nbrMessage;
                return conv;
              })
            )
          );
        });
        return forkJoin(conversationAvecNbMessage);
      }),
      tap(c => console.log(c))
    );

    // this.convService
    //   .getConversation(this.conversation.id)
    //   .subscribe(count => (this.conversation = count));
    // this.convService
    //   .countMessages(this.conversation.id)
    //   .subscribe(count => (this.nbMessages = count));
  }
}
