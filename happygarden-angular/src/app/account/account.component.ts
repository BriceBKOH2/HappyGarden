import { Component, OnInit } from '@angular/core';
import { UserAccount } from '../classes/user-account';
import { HttpClient } from '@angular/common/http';
import { AuthenticateService } from '../authenticate/services/authenticate.service';

@Component({
  selector: 'app-account',
  templateUrl: './account.component.html',
  styleUrls: ['./account.component.scss']
})
export class AccountComponent implements OnInit {
  public users: UserAccount[];

  constructor(
    private httpClient: HttpClient,
    public authServ: AuthenticateService
  ) {}

  ngOnInit() {
    this.httpClient
      .get<UserAccount[]>('http://localhost:8082/happygarden/api/Admin/users')
      .subscribe(data => {
        this.users = data;
      });
  }
}
