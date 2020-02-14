import { Component, OnInit } from '@angular/core';
import { UserAccount } from 'src/app/classes/user-account';
import { switchMap } from 'rxjs/operators';
import { AccountService } from '../service/account.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-accountpage',
  templateUrl: './accountpage.component.html',
  styleUrls: ['./accountpage.component.scss']
})
export class AccountpageComponent implements OnInit {
  constructor(
    private accountService: AccountService,
    private activatedRoute: ActivatedRoute
  ) {}

  user: UserAccount;

  ngOnInit() {
    this.activatedRoute.params
      .pipe(
        switchMap(params => {
          console.log(params);
          return this.accountService.getUser(params.id);
        })
      )
      .subscribe(response => {
        console.log(response);
        this.user = response;
      });
  }
}
