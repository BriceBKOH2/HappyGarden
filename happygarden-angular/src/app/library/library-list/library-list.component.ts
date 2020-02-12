import { Component, OnInit } from '@angular/core';
import { UserAccountRequestService } from 'src/app/service/userAccountRequest/user-account-request.service';

@Component({
  selector: 'app-library-list',
  templateUrl: './library-list.component.html',
  styleUrls: ['./library-list.component.scss']
})
export class LibraryListComponent implements OnInit {
  constructor(public userService: UserAccountRequestService) {}

  ngOnInit() {}

  changeId() {}
}
