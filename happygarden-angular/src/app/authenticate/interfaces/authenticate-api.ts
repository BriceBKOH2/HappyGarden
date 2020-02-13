import { Observable } from 'rxjs';

export interface AuthenticateApi {
  login(username: string, password: string): Observable<any>;
  logout(): Observable<void>;
}
