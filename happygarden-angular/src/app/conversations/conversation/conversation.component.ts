import { Component, OnInit } from '@angular/core';
import { AuthenticateService } from 'src/app/authenticate/services/authenticate.service';
import { ConversationsService } from '../service/conversations.service';
import { Conversation } from 'src/app/classes/conversation';
import { switchMap } from 'rxjs/operators';
import { ActivatedRoute } from '@angular/router';
import { Message } from 'src/app/classes/Message';
import { FormGroup, FormControl, Validators } from '@angular/forms';

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

  message: Message;

  sendMessageForm = new FormGroup({
    author: new FormControl('', Validators.required),
    content: new FormControl('', Validators.required)
  });

  onSubmitCreationForm() {
    this.message.author = this.sendMessageForm.value.author;
    this.message.content = this.sendMessageForm.value.content;
  }

  ngOnInit() {
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

  sendMessage() {
    this.message.author = this.sendMessageForm.value.author;
    this.message.content = this.sendMessageForm.value.content;

    this.convService.sendMessage(this.message).subscribe(response => {
      this.message = response;
    });
  }
}
