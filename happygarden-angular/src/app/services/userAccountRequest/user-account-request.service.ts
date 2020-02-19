import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { UserAccount } from '../../classes/user-account';
import { Observable, BehaviorSubject } from 'rxjs';
import { RequestService } from '../request/request.service';
import { UserRole } from 'src/app/classes/user-role';
import { UserRolesService } from '../userRoles/user-roles.service';
import { userInfo } from 'os';

@Injectable({
  providedIn: 'root'
})
export class UserAccountRequestService {

  constructor(private httpClient: HttpClient,
     private request: RequestService,
     private roleServ: UserRolesService) {
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

  createUserAccount(
    submittedUsername: string,
    submittedPassword: string,
    submittedFirstname: string,
    submittedLastname: string): Observable<UserAccount> {

    let newUser: UserAccount;
    let user = new BehaviorSubject<UserAccount>(null);
    this.roleServ.defaultRole.subscribe(
      (r) => {
        newUser = {
          firstname: submittedFirstname,
          lastname: submittedLastname,
          nickname: submittedUsername,
          password: submittedPassword,
          userRole: r
        };
        console.log(`envoi de la requête avec le nouvel user vers ${this.endPoint}`);
        console.log(newUser);

        // creating and retrieving new user
        this.httpClient.post<UserAccount>(this.endPoint, JSON.stringify(newUser))
          .subscribe(
            (response: UserAccount) => (user.next(response)),
            (error) => {
              console.log("create User: error");
              console.log(error);
            }
          );
        // -------------------------------------

      },
      (err) => (console.log(err))
    );
    return user;
  }
}
