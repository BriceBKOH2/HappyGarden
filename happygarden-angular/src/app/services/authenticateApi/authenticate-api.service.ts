import { Injectable } from '@angular/core';
import { AuthenticateApi } from 'src/app/authenticate/interfaces/authenticate-api';
import { Observable, BehaviorSubject, of } from 'rxjs';
import { HttpClient, HttpParams, HttpErrorResponse } from '@angular/common/http';
import { RequestService } from '../request/request.service';
import { UserAccount } from 'src/app/classes/user-account';
import { UserAccountRequestService } from '../userAccountRequest/user-account-request.service';
import { catchError } from 'rxjs/operators';

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

    // this.httpClient.post(this.endPointLogin, null, { params } ).subscribe(
    //   (value) => (console.log("login post subscribe value " + value)),
    //   (error) => (console.log("login post subscribe error >" + error)),
    //   () => {
    //     this.userServ.getUserAccountByNickname(username).subscribe(
    //       (response) => {
    //         console.log("getUser : response ");
    //         console.log(response);
    //         (user.next(response));
    //       },
    //       (error) => {
    //         console.log("getUser : error " + error);
    //         (error.next(error));
    //       },
    //       () => {
    //         console.log("getUser : complete ");
    //       }
    //     );
    //     console.log("login post subscribe complete");
    //   }
    // );

    this.httpClient.post(this.endPointLogin, null, {params})
      .pipe(catchError(val => of(val)))
      .subscribe(
        (err) => {
          // we check if value contains an error
          if (err instanceof HttpErrorResponse) {
            alert(err.status + ' : ' + err.message);
          } else {
            // no error : retrieving account
            this.userServ.getUserAccountByNickname(username).subscribe(
              (response: UserAccount) => (user.next(response)),
              (error) => {
                console.log("getUser : error ");
                console.log(error);
              }
            );
          }
        }
      );

    return user;
  }

  logout(): Observable<any> {
    return this.httpClient.get(this.endPointLogout);
    // return this.httpClient.delete<void>(this.endPointLogout);
  }
}
