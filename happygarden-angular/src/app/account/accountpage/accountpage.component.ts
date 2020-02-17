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
  constructor(public authServ: AuthenticateService) {}
  // userSave = new UserAccount();
  ngOnInit() {
    // this.authServ.user$.subscribe(response => (this.userSave = response));
  }
}
