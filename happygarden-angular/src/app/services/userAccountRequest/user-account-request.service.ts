import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { UserAccount } from '../../classes/user-account';
import { Observable } from 'rxjs';
import { RequestService } from '../request/request.service';
import { UserRole } from 'src/app/classes/user-role';

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

  createUserAccount(submittedUsername: string, submittedPassword: string): Observable<UserAccount> {

    const newUser: UserAccount = {
      firstname: 'default',
      lastname: 'default',
      nickname: submittedUsername,
      password: submittedPassword,
      userRole: {name:'Basic', userRights: null}
    };

    return this.httpClient.post<UserAccount>(this.endPoint, newUser);
  }
}
