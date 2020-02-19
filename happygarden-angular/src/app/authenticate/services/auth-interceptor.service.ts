import {
  HttpInterceptor,
  HttpRequest,
  HttpHandler,
  HttpEvent
} from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AuthenticateApiService } from 'src/app/services/authenticateApi/authenticate-api.service';

@Injectable({
  providedIn: 'root'
})
export class AuthInterceptorService implements HttpInterceptor {
  constructor(private authServ: AuthenticateApiService) {}

  intercept(
    request: HttpRequest<any>,
    next: HttpHandler
  ): Observable<HttpEvent<any>> {
    request = request.clone({
      setHeaders: {
        'Content-Type': 'application/json'
      },
      // setHeaders: {
      //   Authorization: `Bearer ${this.authServ.token}`
      // },
      withCredentials: true
    });
    return next.handle(request);
  }
}
