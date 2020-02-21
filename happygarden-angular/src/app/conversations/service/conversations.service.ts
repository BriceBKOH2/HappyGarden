import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { RequestService } from 'src/app/services/request/request.service';
import { Observable, of } from 'rxjs';
import { Conversation } from 'src/app/classes/conversation';
import { Message } from 'src/app/classes/Message';

@Injectable({
  providedIn: 'root'
})
export class ConversationsService {
  get endPointConversation() {
    return this.request.endPoint + '/Conversation';
  }
  get endPointMessage() {
    return this.request.endPoint + '/Message';
  }
  constructor(
    private httpClient: HttpClient,
    private request: RequestService
  ) {}

  getConversations(id: number): Observable<Conversation[]> {
    return this.httpClient.get<Conversation[]>(
      `${this.endPointConversation}/user/${id}`
    );
  }

  getMessagesConversation(id: number): Observable<Message[]> {
    // return this.httpClient.get<Conversation>(`${this.endPointUser}/${id}`);
    return this.httpClient.get<Message[]>(`${this.endPointMessage}/conv/${id}`);
  }

  getConversation(id: number): Observable<Conversation> {
    // return this.httpClient.get<Conversation>(`${this.endPointUser}/${id}`);
    return this.httpClient.get<Conversation>(
      `${this.endPointConversation}/${id}`
    );
  }

  sendMessage(message: Message): Observable<Message> {
    console.log(JSON.stringify(message));
    return this.httpClient.post<Message>(
      this.endPointMessage,
      JSON.stringify(message)
    );
  }

  updateConversation(conversation: Conversation): Observable<Conversation> {
    console.log(conversation);
    // return this.httpClient.put<Conversation>(
    //   this.endPointConversation,
    //   conversation
    // );
    return this.httpClient.put<Conversation>(
      this.endPointConversation,
      JSON.stringify(conversation)
    );
  }
}
