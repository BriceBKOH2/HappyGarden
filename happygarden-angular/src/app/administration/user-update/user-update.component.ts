import { Component, OnInit, OnDestroy } from '@angular/core';
import { UserAccountRequestService } from 'src/app/services/userAccountRequest/user-account-request.service';
import { UserAccount } from '../../classes/user-account';
import { Router } from '@angular/router';
import { ActivatedRoute } from '@angular/router';
import { switchMap } from 'rxjs/operators';
import { untilDestroyed } from 'ngx-take-until-destroy';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-user-update',
  templateUrl: './user-update.component.html',
  styleUrls: ['./user-update.component.scss']
})
export class UserUpdateComponent implements OnInit, OnDestroy {
  id: number;
  user: UserAccount;

  constructor(
    private router: Router,
    private userAccountRequestService: UserAccountRequestService,
    private activatedRoute: ActivatedRoute
  ) {}

  ngOnInit() {

    this.id = this.activatedRoute.snapshot.params['id'];
    this.activatedRoute.params
      .pipe(
        switchMap(params => {
          return this.userAccountRequestService.findUser(params.id);
        }),
        untilDestroyed(this)
      ).subscribe(
        (value) => (this.user = value)
      )
  }

  updateUser() {
    console.log(this.user);
    this.userAccountRequestService.updateUser(this.id, this.user)
      .pipe(untilDestroyed(this))
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

    ngOnDestroy(): void {
    }
}
