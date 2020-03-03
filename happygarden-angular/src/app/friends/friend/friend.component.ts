import { Component, OnInit } from '@angular/core';
import { AccountService } from 'src/app/account/service/account.service';
import { UserAccount } from 'src/app/classes/user-account';
import { Observable } from 'rxjs';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-friend',
  templateUrl: './friend.component.html',
  styleUrls: ['./friend.component.scss']
})
export class FriendComponent implements OnInit {
  constructor(
    public accountService: AccountService,
    private activatedRoute: ActivatedRoute
  ) {}

  friend$: Observable<UserAccount>;

  ngOnInit() {
    this.activatedRoute.params.subscribe(param => {
      this.friend$ = this.accountService.getUser(param.id);
    });
  }
}
