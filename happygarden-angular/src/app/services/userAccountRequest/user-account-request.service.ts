import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { UserAccount } from '../../classes/user-account';
import { Observable } from 'rxjs';
import { RequestService } from '../request/request.service';
import { AuthenticateService } from 'src/app/authenticate/services/authenticate.service';
import { Garden } from 'src/app/classes/garden';

@Injectable({
  providedIn: 'root'
})
export class UserAccountRequestService {
  constructor(
    private httpClient: HttpClient,
    private request: RequestService
  ) {}

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

  getGardens(id: number): Observable<Garden[]> {
    return this.httpClient.get<Garden[]>(`${this.endPoint}/${id}/gardens`);
  }
}
