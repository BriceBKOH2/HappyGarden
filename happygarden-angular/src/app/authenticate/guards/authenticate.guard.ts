import { Injectable } from '@angular/core';
import {
  ActivatedRouteSnapshot,
  CanActivate,
  RouterStateSnapshot,
  UrlTree,
  Router
} from '@angular/router';
import { Observable } from 'rxjs';
import { tap } from 'rxjs/operators';
import { AuthenticateService } from '../services/authenticate.service';

@Injectable({
  providedIn: 'root'
})
export class AuthenticateGuard implements CanActivate {
  constructor(private authService: AuthenticateService, private router: Router) {}

  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot
  ):
    | Observable<boolean | UrlTree>
    | Promise<boolean | UrlTree>
    | boolean
    | UrlTree {

    let test = false;
    this.authService.isAuthentificated$.subscribe((t) => (test = t)).unsubscribe();

    if (test) {
      console.log('is authenticated', true);
      return true;
    } else {
      console.log('is authenticated', false);
      // this.router.navigate(['/login?', {needlogin: 'true'}]);
      // return false;
      return this.router.parseUrl('notloggedin');
    }

    // return this.authService.isAuthentificated$
    // .pipe(
    //   tap(isAuth => {
    //     console.log('is authenticated', isAuth);
    //   })
    // );
  }
}
