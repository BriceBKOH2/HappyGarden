import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { RequestService } from 'src/app/services/request/request.service';
import { UserAccount } from 'src/app/classes/user-account';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class FriendsService {
  get endPointConversation() {
    return this.request.endPoint + '/UserAccount';
  }

  constructor(
    private httpClient: HttpClient,
    private request: RequestService
  ) {}

  getFriends(id: number): Observable<UserAccount[]> {
    return this.httpClient.get<UserAccount[]>(
      `${this.endPointConversation}/friends/${id}`
    );
  }

  getFriendProfile(id: number): Observable<UserAccount> {
    return this.httpClient.get<UserAccount>(
      `${this.endPointConversation}/friend/${id}`
    );
  }

  countGardens(id: number): Observable<number> {
    return this.httpClient.get<number>(
      `${this.endPointConversation}/${id}/gardens/count`
    );
  }
}
