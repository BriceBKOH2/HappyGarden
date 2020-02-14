import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { UserAccount } from '../../classes/user-account';
import { Observable } from 'rxjs';
import { RequestService } from '../request/request.service';

@Injectable({
  providedIn: 'root'
})
export class UserAccountRequestService {

  constructor(private httpClient: HttpClient, private request: RequestService) {
  }

  get endPoint(): string {
    return this.request.endPoint + '/UserAccount';
  }

  getUserAccounts(): Observable<UserAccount[]> {
    return this.httpClient.get<UserAccount[]>(this.endPoint);
  }

  getUserAccountById(id: number): Observable<UserAccount> {
    return this.httpClient.get<UserAccount>(`${this.endPoint}/${id}`);
  }

  getUserAccountByNickname(nickname: string): Observable<UserAccount> {
    return this.httpClient.get<UserAccount>(
      `${this.endPoint}/nickname/${nickname}`
    );
  }
}
