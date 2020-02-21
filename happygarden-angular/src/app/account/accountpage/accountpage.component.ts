import { Component, OnInit } from '@angular/core';
import { UserAccount } from 'src/app/classes/user-account';
import { switchMap } from 'rxjs/operators';
import { AccountService } from '../service/account.service';
import { ActivatedRoute } from '@angular/router';
import { AuthenticateService } from 'src/app/authenticate/services/authenticate.service';

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
  nbGardens: number;
  nbConvs: number;
  nbFriends: number;
  ngOnInit() {
    let id: number;
    this.authServ.user$.subscribe(response => {
      id = response.id;
      this.accountService
        .countGardens(id)
        .subscribe(count => (this.nbGardens = count));
      this.accountService
        .countConvs(id)
        .subscribe(count => (this.nbConvs = count));
      this.accountService
        .countFriends(id)
        .subscribe(count => (this.nbFriends = count));
    });
  }
}
