import { Component, OnInit } from '@angular/core';
import { UserAccount } from '../../classes/user-account';
import { UserAccountRequestService } from 'src/app/services/userAccountRequest/user-account-request.service';
import { ActivatedRoute } from '@angular/router';
import { switchMap } from 'rxjs/operators';


@Component({
  selector: 'app-user-single',
  templateUrl: './user-single.component.html',
  styleUrls: ['./user-single.component.scss']
})
export class UserSingleComponent implements OnInit {

  public user: UserAccount = new UserAccount();

  constructor(
    private userAccountRequestService: UserAccountRequestService,
    private activatedRoute: ActivatedRoute
  ) {
  }

  ngOnInit() {
    this.activatedRoute.params
      .pipe(
        switchMap(params => {
          console.log(params);
          return this.userAccountRequestService.findUser(params.id);
        })
      )
      .subscribe(response => {
        console.log(response);
        this.user = response;
      });
  }

}
