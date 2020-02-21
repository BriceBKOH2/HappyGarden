import { Injectable } from '@angular/core';
import { RequestService } from '../request/request.service';
import { HttpClient } from '@angular/common/http';
import { UserRole } from 'src/app/classes/user-role';
import { Observable } from 'rxjs';

/**
 * Service responsible to retrieves roles in db.
 */
@Injectable({
  providedIn: 'root'
})
export class UserRolesService {

  constructor(private httpClient: HttpClient, private request: RequestService) { }

  get endPoint(): string {
    return this.request.endPoint + '/UserRole';
  }

  get defaultRole(): Observable<UserRole> {
    return this.httpClient.get<UserRole>(this.endPoint + '/getDefaultRole');
  }
}
