import { Component, OnInit } from '@angular/core';
import { AuthenticateService } from 'src/app/authenticate/services/authenticate.service';
import { ConversationsService } from '../service/conversations.service';
import { Conversation } from 'src/app/classes/conversation';
import { switchMap } from 'rxjs/operators';
import { ActivatedRoute } from '@angular/router';
import { Message } from 'src/app/classes/Message';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-conversation',
  templateUrl: './conversation.component.html',
  styleUrls: ['./conversation.component.scss']
})
export class ConversationComponent implements OnInit {
  messages: Message[] = [];

  message: Message;

  conversation: Conversation;

  message$: Observable<Message>;

  conversation$: Observable<Conversation>;

  constructor(
    public authServ: AuthenticateService,
    private convService: ConversationsService,
    private activatedRoute: ActivatedRoute,
    private router: Router
  ) {
    this.message = new Message();
  }

  sendMessageForm = new FormGroup({
    author: new FormControl('', Validators.required),
    content: new FormControl('', Validators.required),
    conversation: new FormControl('', Validators.required)
  });

  onSubmitCreationForm() {
    this.authServ.user$.subscribe(
      user => (this.message.author = user.nickname)
    );
    //----CONV-----------------
    this.message.conversation = this.conversation;
    this.message.content = this.sendMessageForm.value.content;
  }

  ngOnInit() {
    this.activatedRoute.params
      .pipe(
        switchMap(params => {
          this.convService
            .getConversation(params.id)
            .subscribe(response => (this.conversation = response));
          return this.convService.getMessagesConversation(params.id);
        })
      )
      .subscribe(response => {
        console.log(response);
        this.messages = response;
        console.log(this.message.conversation.id);
      });
  }

  sendMessage() {
    this.authServ.user$.subscribe(
      user => (this.message.author = user.nickname)
    );
    this.message.conversation = this.conversation;
    this.message.content = this.sendMessageForm.value.content;

    this.convService.sendMessage(this.message).subscribe(response => {
      this.message = response;
      console.log(this.message);
      this.message = new Message();
      this.router.navigate([
        'userAccount/conversations/',
        { queryParams: { refresh: 2 } }
      ]);
    });
  }
}
