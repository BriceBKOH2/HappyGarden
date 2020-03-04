import { Component, OnInit } from '@angular/core';
import { AuthenticateService } from 'src/app/authenticate/services/authenticate.service';
import { AccountService } from '../service/account.service';
import { Observable } from 'rxjs';
import { switchMap, map } from 'rxjs/operators';

@Component({
  selector: 'app-accountpage',
  templateUrl: './accountpage.component.html',
  styleUrls: ['./accountpage.component.scss']
})
export class AccountpageComponent implements OnInit {
  constructor(
    public authServ: AuthenticateService,
    private accountService: AccountService
  ) {}
  //userSave = new UserAccount()
  nbGardens$: Observable<number>;
  nbConvs$: Observable<number>;
  nbFriends$: Observable<number>;
  ngOnInit() {
    this.nbGardens$ = this.authServ.user$.pipe(
      map(response => response.id),
      switchMap(id => this.accountService.countGardens(id))
    );
    this.nbConvs$ = this.authServ.user$.pipe(
      map(response => response.id),
      switchMap(id => this.accountService.countConvs(id))
    );
    this.nbFriends$ = this.authServ.user$.pipe(
      map(response => response.id),
      switchMap(id => this.accountService.countFriends(id))
    );
  }
}
