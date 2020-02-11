import { Injectable } from '@angular/core';
import { AuthenticateApi } from 'src/app/authenticate/interface/authenticate-api';
import { Observable } from 'rxjs';
import { UserAccount } from 'src/app/classes/user-account';
import { HttpClientModule, HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AuthenticateApiService implements AuthenticateApi {
  userAccount = new UserAccount();
  token: String;

  constructor(private httpClient: HttpClient) {}

  login(data: { username: string; password: string }): Observable<any> {
    return this.httpClient.post<{ token: string }>('/login', data);
  }

  logout(): Observable<void> {
    return this.httpClient.delete<void>('/logout');
  }
}
