import { Component, OnInit } from '@angular/core';
import { UserAccount } from '../../classes/user-account';
import { UserAccountRequestService } from 'src/app/services/userAccountRequest/user-account-request.service';
import { ActivatedRoute } from '@angular/router';
import { switchMap } from 'rxjs/operators';
import { Observable } from 'rxjs';


@Component({
  selector: 'app-user-single',
  templateUrl: './user-details.component.html',
  styleUrls: ['./user-details.component.scss']
})
export class UserDetailsComponent implements OnInit {

  user$: Observable<UserAccount>

  constructor(
    private userAccountRequestService: UserAccountRequestService,
    private activatedRoute: ActivatedRoute
  ) {
  }

  ngOnInit() {
    this.user$ = this.activatedRoute.params
      .pipe(
        switchMap(params => {
          return this.userAccountRequestService.findUser(params.id);
        })
      )
  }

}
