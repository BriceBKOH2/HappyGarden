import { Component, OnInit } from '@angular/core';
import { AuthenticateService } from 'src/app/authenticate/services/authenticate.service';
import { FriendsService } from '../service/friends.service';
import { ActivatedRoute } from '@angular/router';
import { UserAccount } from 'src/app/classes/user-account';
import { switchMap, map, tap } from 'rxjs/operators';
import { Observable, forkJoin } from 'rxjs';

@Component({
  selector: 'app-friends-list',
  templateUrl: './friends-list.component.html',
  styleUrls: ['./friends-list.component.scss']
})
export class FriendsListComponent implements OnInit {
  constructor(
    public authServ: AuthenticateService,
    private friendsService: FriendsService,
    private activatedRoute: ActivatedRoute
  ) {}

  friends$: Observable<UserAccount[]>;

  ngOnInit() {
    let id: number;
    this.authServ.user$.subscribe(response => (id = response.id));

    // this.friendsService.getFriends(id).subscribe(response => {
    //   this.friends = response;

    this.friends$ = this.friendsService.getFriends(id);
  }
}
