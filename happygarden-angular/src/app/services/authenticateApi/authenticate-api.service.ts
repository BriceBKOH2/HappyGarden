import { Injectable } from '@angular/core';
import { AuthenticateApi } from 'src/app/authenticate/interfaces/authenticate-api';
import { Observable, BehaviorSubject, of, throwError } from 'rxjs';
import {
  HttpClient,
  HttpParams,
  HttpErrorResponse
} from '@angular/common/http';
import { RequestService } from '../request/request.service';
import { UserAccount } from 'src/app/classes/user-account';
import { UserAccountRequestService } from '../userAccountRequest/user-account-request.service';
import { catchError, switchMap } from 'rxjs/operators';

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

  /**
   * Request back end to log in with specified credentials and returns an Observable of the
   * connected UserAccount if successfully logged in.
   * @param username
   * @param password
   * @returns an Observable of the connected UserAccount if successfully logged in.
   */
  login(username: string, password: string): Observable<UserAccount> {
    let params = new HttpParams()
      .set('username', username)
      .set('password', password);

    return this.httpClient.post(this.endPointLogin, null, { params }).pipe(
      switchMap(() => {
        return this.userServ.getUserAccountByNickname(username);
      }),
      catchError(err => {
        if (err instanceof HttpErrorResponse) {
          console.log('HttpErrorResponse : ');
          console.log(err);
        } else {
          console.log('Not and HttpErrorResponse : ');
          console.log(err);
        }
        return throwError(err);
      })
    );
  }

  logout(): Observable<any> {
    return this.httpClient.get(this.endPointLogout);
  }
}
