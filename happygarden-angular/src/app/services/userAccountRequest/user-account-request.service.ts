import { Injectable } from '@angular/core';
import { HttpClient, HttpParams, HttpHeaders } from '@angular/common/http';
import { UserAccount } from '../../classes/user-account';
import { Observable, BehaviorSubject } from 'rxjs';
import { RequestService } from '../request/request.service';
import { UserRolesService } from '../userRoles/user-roles.service';
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

  findUser(id: number): Observable<UserAccount> {
    return this.httpClient.get<UserAccount>(`${this.endPoint}/${id}`);
  }

  deleteUser(id: number) {
    return this.httpClient.delete(`${this.endPoint}/${id}`);
  }

  deleteAllEntityFromUser(id: number) {
    return this.httpClient.delete(`${this.endPoint}/deleteall/${id}`);
  }

  updateUser(id: number, value: any) {
    return this.httpClient.put(`${this.endPoint}/`, value);
  }

  getUserAccountByNickname(nickname: string): Observable<UserAccount> {
    return this.httpClient.get<UserAccount>(
      `${this.endPoint}/nickname/${nickname}`
    );
  }

  getGardens(id: number): Observable<Garden[]> {
    return this.httpClient.get<Garden[]>(`${this.endPoint}/${id}/gardens`);
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

  findAllUser(): Observable<UserAccount[]> {
    return this.httpClient.get<UserAccount[]>(this.endPoint);
  }

  searchByFirstnameOrLastnameOrNickName(name: string): Observable<UserAccount[]> {
    return this.httpClient.get<UserAccount[]>(`${this.endPoint}/search`, {
      params: new HttpParams().set('name', name)
    });
  }
}
