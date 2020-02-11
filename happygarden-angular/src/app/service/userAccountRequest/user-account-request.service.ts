import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { UserAccount } from '../../classes/user-account';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserAccountRequestService {
  userAccount = new UserAccount();

  constructor(private httpClient: HttpClient) {
    this.getUserAccountByNickname('admin').subscribe(
      response => (this.userAccount = response)
    );
  }

  get endPoint(): string {
    return 'http://localhost:8082/happygarden/api/UserAccount';
  }

  getUserAccounts(): Observable<UserAccount[]> {
    return this.httpClient.get<UserAccount[]>(`${this.endPoint}/`);
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
