import { Injectable } from '@angular/core';
import {
  HttpErrorResponse,
  HttpEvent,
  HttpHandler,
  HttpInterceptor,
  HttpRequest,
  HttpResponse
} from '@angular/common/http';
import { AuthenticateService } from './authenticate.service';
import { Observable, of, throwError } from 'rxjs';
import { catchError, switchMap } from 'rxjs/operators';

@Injectable()
export class HttpInterceptorAuthService implements HttpInterceptor {
  constructor(private authService: AuthenticateService) {}

  intercept(
    req: HttpRequest<any>,
    next: HttpHandler
  ): Observable<HttpEvent<any>> {
    return this.authService.isAuthentificated$.pipe(
      switchMap(isAuth => {
        if (isAuth === true) {
          return this.authService.userAuth$.pipe(
            switchMap(user => {
              const request = req.clone({
                headers: req.headers.append(
                  'Authorization',
                  `Bearer ${user.token}`
                )
              });
              return next.handle(request);
            })
          );
        }
        return next.handle(req);
      })
    );
  }
}
