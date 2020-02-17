import { Component, OnInit } from '@angular/core';
import { Observable } from "rxjs";
import { UserAccountRequestService } from 'src/app/services/userAccountRequest/user-account-request.service';
import { UserAccount } from '../../classes/user-account';
import { Router } from '@angular/router';
import { FormControl, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-user-management',
  templateUrl: './user-management.component.html',
  styleUrls: ['./user-management.component.scss']
})

export class UserManagementComponent implements OnInit {
 users: UserAccount[] = [];
  /*users : Observable<UserAccount[]>;
  usersTab: UserAccount[];*/

  searchUserFrom = new FormGroup({
    userName: new FormControl()
  });

  constructor(private userService : UserAccountRequestService,
     private router: Router) {}

  ngOnInit() {
    this.userService.findAllUser().subscribe(response => {
      console.log(response);
      this.users = response;
    });

  }

  searchUser() {
    this.userService
      .searchByFirstnameOrLastnameOrNickName(this.searchUserFrom.value.userName)
      .subscribe(response => (this.users = response));
  }

  deleteUser(id: number) {
    this.userService.deleteUser(id)
    .subscribe(
      data => {
        console.log(data);
        this.users;
      },
      error => console.log(error)
    );
  }

}
