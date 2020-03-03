import { Component, OnInit, OnDestroy } from '@angular/core';
import { Observable } from "rxjs";
import { UserAccountRequestService } from 'src/app/services/userAccountRequest/user-account-request.service';
import { UserAccount } from '../../classes/user-account';
import { Router } from '@angular/router';
import { ReactiveFormsModule, FormControl, FormGroup } from '@angular/forms';
import { untilDestroyed } from 'ngx-take-until-destroy';

@Component({
  selector: 'app-user-management',
  templateUrl: './user-management.component.html',
  styleUrls: ['./user-management.component.scss']
})

export class UserManagementComponent implements OnInit, OnDestroy {

  users$: Observable<UserAccount[]>;
  // users: UserAccount[] = [];
  /*users : Observable<UserAccount[]>;
  usersTab: UserAccount[];*/

  searchUserFrom = new FormGroup({
    userName: new FormControl('')
  });

  constructor(private userService : UserAccountRequestService,
     private router: Router) {}

  ngOnInit() {
    this.users$ = this.userService.findAllUser();
    // .subscribe(response => {
    //   this.users = response;
    // });

  }

  searchUser() {
    this.users$ = this.userService
      .searchByFirstnameOrLastnameOrNickName(this.searchUserFrom.value.userName);
      // .subscribe(response => (this.users = response));
  }

  deleteUser(id: number) {
    if (confirm("Cette action est irréversible. Voulez-vous vraiment supprimer cet utilisateur ?")) {
      this.userService.deleteUser(id)
      .pipe(untilDestroyed(this))
      .subscribe(
        () => {
          this.searchUser();
          this.router.navigate(['admin/usermanagement']);
        },
        error => console.log(error)
      );
    }
  }

  ngOnDestroy(): void {
  }

}
