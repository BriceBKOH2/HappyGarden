import { Component, OnInit } from '@angular/core';
import { AuthenticateService } from 'src/app/authenticate/services/authenticate.service';
import { ConversationsService } from '../service/conversations.service';
import { Conversation } from 'src/app/classes/conversation';
import { switchMap, tap, map } from 'rxjs/operators';
import { ActivatedRoute } from '@angular/router';
import { Message } from 'src/app/classes/Message';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Observable, BehaviorSubject, combineLatest } from 'rxjs';

@Component({
  selector: 'app-conversation',
  templateUrl: './conversation.component.html',
  styleUrls: ['./conversation.component.scss']
})
export class ConversationComponent implements OnInit {
  messages: Message[] = [];

  message: Message;

  conversation: Conversation;

  messages$: Observable<Message[]>;

  conversation$: Observable<Conversation>;

  refresh$: BehaviorSubject<boolean> = new BehaviorSubject<boolean>(true);

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
    this.conversation$ = this.activatedRoute.params.pipe(
      switchMap(params => {
        return this.convService.getConversation(params.id);
      }),
      tap(c => (this.conversation = c))
    );
    this.messages$ = combineLatest(this.conversation$, this.refresh$).pipe(
      switchMap(([c]) => {
        return this.convService.getMessagesConversation(c.id);
      })
    );
  }

  sendMessage() {
    this.authServ.user$.subscribe(
      user => (this.message.author = user.nickname)
    );
    this.message.conversation = this.conversation;
    this.message.content = this.sendMessageForm.value.content;

    this.authServ.user$
      .pipe(
        map(user => {
          this.message.author = user.nickname;
          this.message.conversation = this.conversation;
          this.message.content = this.sendMessageForm.value.content;
          console.log(this.conversation);
          return this.message;
        }),
        switchMap(message => {
          return this.convService.sendMessage(message);
        })
      )
      .subscribe(res => {
        console.log(res);
        this.message = new Message();
        this.refresh$.next(true);
      });
  }
}
