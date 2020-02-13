import { Injectable } from '@angular/core';
import { AuthenticateApi } from 'src/app/authenticate/interfaces/authenticate-api';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { RequestService } from '../request/request.service';
import { UserAccount } from 'src/app/classes/user-account';
import { UserAccountRequestService } from '../userAccountRequest/user-account-request.service';

@Injectable({
  providedIn: 'root'
})
export class AuthenticateApiService implements AuthenticateApi {
  constructor(
    private httpClient: HttpClient,
    private request: RequestService,
    private userServ: UserAccountRequestService
  ) {}

  get endPointLogin(): string {
    return this.request.endPoint + '/login';
  }

  get endPointLogout(): string {
    return this.request.endPoint + '/logout';
  }

  login(username: string, password: string): Observable<UserAccount> {
    this.httpClient.post<UserAccount>(this.endPointLogin, null, {
      params: {
        username: username,
        password: password
      }
    });
    return this.userServ.getUserAccountByNickname(username);
  }

  logout(): Observable<void> {
    return this.httpClient.delete<void>(this.endPointLogout);
  }
}
