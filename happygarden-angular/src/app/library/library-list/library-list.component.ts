import { Component, OnInit } from '@angular/core';
import { UserAccountRequestServiceService } from 'src/app/service/user-account-request-service.service';

@Component({
  selector: 'app-library-list',
  templateUrl: './library-list.component.html',
  styleUrls: ['./library-list.component.scss']
})
export class LibraryListComponent implements OnInit {
  constructor(public userService: UserAccountRequestServiceService) {}

  ngOnInit() {}

  changeId() {
    this.userService.userAccount.id = 1000;
  }
}
