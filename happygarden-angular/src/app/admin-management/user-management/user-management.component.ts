import { Component, OnInit } from '@angular/core';
import { Observable } from "rxjs";
import { UserAccountRequestService } from 'src/app/service/userAccountRequest/user-account-request.service';
import { UserAccount } from '../../classes/user-account';
import { Router } from '@angular/router';


@Component({
  selector: 'app-user-management',
  templateUrl: './user-management.component.html',
  styleUrls: ['./user-management.component.scss']
})

export class UserManagementComponent implements OnInit {
  users : Observable<UserAccount[]>;
  usersTab: UserAccount[];


  constructor(private userService : UserAccountRequestService,
     private router: Router) {}

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
    this.users = this.userService.getUserAccounts();
  }

}
