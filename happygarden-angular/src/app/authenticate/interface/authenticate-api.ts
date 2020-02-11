import { Observable } from 'rxjs';

export interface AuthenticateApi {
  login(data: any): Observable<any>;
  logout(): Observable<void>;
}
