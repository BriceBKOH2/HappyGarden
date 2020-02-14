import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { UserAccount } from 'src/app/classes/user-account';

@Injectable({
  providedIn: 'root'
})
export class AccountService {
  get endPointUser() {
    return 'http://localhost:8082/happygarden/api/UserAccount';
  }

  constructor(private httpClient: HttpClient) {}

  // get httpOptions(): { headers: HttpHeaders } {
  //   const headers = new HttpHeaders().set('Content-Type', 'application/json');
  //   return {
  //     headers
  //   };
  // }

  getUser(id: number): Observable<UserAccount> {
    return this.httpClient.get<UserAccount>(`${this.endPointUser}/${id}`);
  }
}
