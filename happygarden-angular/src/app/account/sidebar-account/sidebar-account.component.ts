import { Component, OnInit } from '@angular/core';
import { AuthenticateService } from 'src/app/authenticate/services/authenticate.service';

@Component({
  selector: 'app-sidebar-account',
  templateUrl: './sidebar-account.component.html',
  styleUrls: ['./sidebar-account.component.scss']
})
export class SidebarAccountComponent implements OnInit {
  constructor(public authServ: AuthenticateService) {}

  ngOnInit() {}
}
