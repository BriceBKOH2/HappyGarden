import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class AuthApiService {
  constructor() {}

  login(data): Observable<any> {
    return of(data);
  }

  logout(): Observable<void> {
    return of(true).pipe(
      map(() => {
        return;
      })
    );
  }
}
