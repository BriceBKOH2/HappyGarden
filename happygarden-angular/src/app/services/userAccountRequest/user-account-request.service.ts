import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { UserAccount } from '../../classes/user-account';
import { Observable } from 'rxjs';
import { RequestService } from '../request/request.service';

@Injectable({
  providedIn: 'root'
})
export class UserAccountRequestService {
  userAccount = new UserAccount();

  constructor(private httpClient: HttpClient, private request: RequestService) {
    this.getUserAccountByNickname('admin').subscribe(
      response => (this.userAccount = response)
    );
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

  findUser(id: number) {
    return this.httpClient.get<UserAccount>(`${this.endPoint}/${id}`);
  }

  deleteUser(id: number) {
    return this.httpClient.delete(`${this.endPoint}/${id}`);
  }

  getUserAccountByNickname(nickname: string): Observable<UserAccount> {
    return this.httpClient.get<UserAccount>(
      `${this.endPoint}/nickname/${nickname}`
    );
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
