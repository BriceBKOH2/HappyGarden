import { Component, OnInit } from '@angular/core';
import { AuthenticateService } from 'src/app/authenticate/services/authenticate.service';
import { AccountService } from '../service/account.service';

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
