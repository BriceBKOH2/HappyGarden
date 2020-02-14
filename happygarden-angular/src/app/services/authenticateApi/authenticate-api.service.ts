import { Injectable } from '@angular/core';
import { AuthenticateApi } from 'src/app/authenticate/interfaces/authenticate-api';
import { Observable, BehaviorSubject } from 'rxjs';
import { HttpClient, HttpParams, HttpHeaders } from '@angular/common/http';
import { RequestService } from '../request/request.service';
import { UserAccount } from 'src/app/classes/user-account';
import { UserAccountRequestService } from '../userAccountRequest/user-account-request.service';
import { map } from 'rxjs/operators';

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
    // httpOptions for the request : contains only params with credentials
    // using httpOtions makes http interceptor fail.
    // const httpOptions = {
    //   headers: new HttpHeaders().set('Content-Type', 'application/json'),
    //   params: new HttpParams().set('username', username).set('password', password)
    // };

    let params = new HttpParams().set('username', username).set('password', password);

    let user = new BehaviorSubject<UserAccount>(null);
    this.httpClient.post(this.endPointLogin, null, { params } ).subscribe(
      () => this.userServ.getUserAccountByNickname(username).subscribe(
        (response) => (user.next(response))
      )
    );

    return user;
  }

  logout(): Observable<any> {
    return this.httpClient.get(this.endPointLogout);
    // return this.httpClient.delete<void>(this.endPointLogout);
  }
}
