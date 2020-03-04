import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { UserAccount } from 'src/app/classes/user-account';
import { RequestService } from 'src/app/services/request/request.service';

@Injectable({
  providedIn: 'root'
})
export class AccountService {
  get endPointUser() {
    return this.request.endPoint + '/UserAccount';
  }

  constructor(
    private httpClient: HttpClient,
    private request: RequestService
  ) {}

  // get httpOptions(): { headers: HttpHeaders } {
  //   const headers = new HttpHeaders().set('Content-Type', 'application/json');
  //   return {
  //     headers
  //   };
  // }

  getUser(id: number): Observable<UserAccount> {
    return this.httpClient.get<UserAccount>(`${this.endPointUser}/${id}`);
  }

  countGardens(id: number): Observable<number> {
    return this.httpClient.get<number>(
      `${this.endPointUser}/${id}/gardens/count`
    );
  }

  countConvs(id: number): Observable<number> {
    return this.httpClient.get<number>(
      `${this.endPointUser}/${id}/conversations/count`
    );
  }

  countFriends(id: number): Observable<number> {
    return this.httpClient.get<number>(
      `${this.endPointUser}/${id}/friends/count`
    );
  }
}
