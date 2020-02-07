import { Component, OnInit } from '@angular/core';
import { UserAccountRequestServiceService } from 'src/app/service/user-account-request-service.service';

@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.scss']
})
export class HomepageComponent implements OnInit {
  constructor(public userService: UserAccountRequestServiceService) {}

  ngOnInit() {}
}
