import { Component, OnInit } from '@angular/core';
import { UserAccountRequestService } from 'src/app/services/userAccountRequest/user-account-request.service';

@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.scss']
})
export class HomepageComponent implements OnInit {
  constructor(public userAccountRequestService: UserAccountRequestService) {
    userAccountRequestService
      .getUserAccountByNickname('admin')
      .subscribe(
        response => (userAccountRequestService.userAccount = response)
      );
  }

  ngOnInit() {}
}
