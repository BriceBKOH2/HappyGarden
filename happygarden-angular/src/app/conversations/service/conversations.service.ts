import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { RequestService } from 'src/app/services/request/request.service';
import { Observable } from 'rxjs';
import { Conversation } from 'src/app/classes/conversation';
import { Message } from 'src/app/classes/Message';

@Injectable({
  providedIn: 'root'
})
export class ConversationsService {
  get endPointUser() {
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
      `${this.endPointUser}/user/${id}`
    );
  }

  getConversation(id: number): Observable<Message[]> {
    // return this.httpClient.get<Conversation>(`${this.endPointUser}/${id}`);
    return this.httpClient.get<Message[]>(`${this.endPointMessage}/conv/${id}`);
  }

  sendMessage(message: Message): Observable<Message> {
    return this.httpClient.put<Message>(this.endPointMessage, message);
  }
}
