import { Injectable } from '@angular/core';
import { AuthenticateApi } from 'src/app/authenticate/interfaces/authenticate-api';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { RequestService } from '../request/request.service';

@Injectable({
  providedIn: 'root'
})
export class AuthenticateApiService implements AuthenticateApi {
  constructor(
    private httpClient: HttpClient,
    private request: RequestService
  ) {}

  get endPointLogin(): string {
    return this.request.endPoint + '/login';
  }

  get endPointLogout(): string {
    return this.request.endPoint + '/logout';
  }

  login(username: string, password: string): Observable<any> {
    return this.httpClient.post(this.endPointLogin, null, {
      params: {
        username: username,
        password: password
      }
    });
  }

  logout(): Observable<void> {
    return this.httpClient.delete<void>(this.endPointLogout);
  }
}
