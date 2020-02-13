import { Component, OnInit } from '@angular/core';
import { UserAccount } from '../classes/user-account';
import { HttpClient } from '@angular/common/http';
import { AuthenticateService } from '../authenticate/services/authenticate.service';
import { RequestService } from '../services/request/request.service';

@Component({
  selector: 'app-account',
  templateUrl: './account.component.html',
  styleUrls: ['./account.component.scss']
})
export class AccountComponent implements OnInit {
  public users: UserAccount[];

  constructor(
    private httpClient: HttpClient,
    private request: RequestService,
    public authServ: AuthenticateService
  ) {}

  ngOnInit() {
    this.httpClient
      .get<UserAccount[]>(this.request.endPoint + '/Admin/users')
      .subscribe(data => {
        this.users = data;
      });
  }
}
