import { Component, OnInit } from '@angular/core';
import { AuthenticateService } from 'src/app/authenticate/services/authenticate.service';
import { ConversationsService } from '../service/conversations.service';
import { Conversation } from 'src/app/classes/conversation';
import { switchMap } from 'rxjs/operators';
import { ActivatedRoute } from '@angular/router';
import { Message } from 'src/app/classes/Message';

@Component({
  selector: 'app-conversation',
  templateUrl: './conversation.component.html',
  styleUrls: ['./conversation.component.scss']
})
export class ConversationComponent implements OnInit {
  constructor(
    public authServ: AuthenticateService,
    private convService: ConversationsService,
    private activatedRoute: ActivatedRoute
  ) {}
  messages: Message[] = [];
  ngOnInit() {
    // let id: number;
    // this.authServ.user$.subscribe(response => {
    //   id = response.id;
    //   this.convService
    //     .getConversation(id)
    //     .subscribe(response => (this.messages = response));
    // });

    this.activatedRoute.params
      .pipe(
        switchMap(params => {
          console.log(params);
          return this.convService.getConversation(params.id);
        })
      )
      .subscribe(response => {
        console.log(response);
        this.messages = response;
      });
  }
}
