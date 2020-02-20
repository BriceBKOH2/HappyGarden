import { Component, OnInit } from '@angular/core';
import { Observable } from "rxjs";
import { UserAccountRequestService } from 'src/app/services/userAccountRequest/user-account-request.service';
import { UserAccount } from '../../classes/user-account';
import { Router } from '@angular/router';
import { FormControl, FormGroup } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { switchMap } from 'rxjs/operators';

@Component({
  selector: 'app-user-update',
  templateUrl: './user-update.component.html',
  styleUrls: ['./user-update.component.scss']
})
export class UserUpdateComponent implements OnInit {
  id: number;
  public user: UserAccount = new UserAccount();

  constructor(
    private router: Router,
    private userAccountRequestService: UserAccountRequestService,
    private activatedRoute: ActivatedRoute
  ) {

   }

  ngOnInit() {

    this.id = this.activatedRoute.snapshot.params['id'];
    this.activatedRoute.params
      .pipe(
        switchMap(params => {
          return this.userAccountRequestService.findUser(params.id);
        })
      )
      .subscribe(response => {
        this.user = response;
      });
  }

  updateUser() {
    this.userAccountRequestService.updateUser(this.id, this.user)
    .subscribe(
      () => {
        this.router.navigate(['admin/usermanagement']);
      },
      error => console.log(error)
    );
  }

    onSubmit(){
      this.updateUser();
    }
}
