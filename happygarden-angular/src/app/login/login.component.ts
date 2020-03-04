import { Component, OnInit, OnDestroy } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';
import { AuthenticateService } from '../authenticate/services/authenticate.service';
import { Observable } from 'rxjs';
import { UserAccountRequestService } from '../services/userAccountRequest/user-account-request.service';
import { untilDestroyed } from 'ngx-take-until-destroy';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit, OnDestroy {
  loginForm: FormGroup;
  createAccForm: FormGroup;
  invalidLogin = false;
  showLogin = true;

  param$: Observable<ParamMap>;

  constructor(
    public authServ: AuthenticateService,
    private userAccServ: UserAccountRequestService,
    private formBuilder: FormBuilder,
    private router: Router,
    public activatedRoute: ActivatedRoute
  ) {}

  /**
   * Validator for password matching when creating new user account.
   * @param group
   */
  checkPwd(group: FormGroup) {
    let password = group.get('password').value;
    let confirmPassword = group.get('passwordConfirm').value;

    return password === confirmPassword ? null : { notSame: true };
  }

  ngOnInit() {
    // Form building
    this.loginForm = this.formBuilder.group({
      username: ['', Validators.compose([Validators.required])],
      password: ['', Validators.required]
    });

    this.createAccForm = this.formBuilder.group(
      {
        username: [
          '',
          Validators.compose([Validators.required, Validators.minLength(4)])
        ],
        firstname: ['', [Validators.required]],
        lastname: ['', [Validators.required]],
        password: ['', Validators.required],
        passwordConfirm: ['', [Validators.required]]
      },
      { validators: this.checkPwd }
    );
  }

  /**
   * Manage credential validation and request to log in.
   */
  onSubmit() {
    if (this.loginForm.invalid) {
      return;
    }
    let username = this.loginForm.controls.username.value;
    let password = this.loginForm.controls.password.value;

    this.authServ
      .login(username, password)
      .pipe(untilDestroyed(this))
      .subscribe(
        () => {
          this.router.navigate(['userAccount']);
        },
        error => {
          this.invalidLogin = true;
          console.log('login.component::onSubmit > error');
          console.log(error);
          alert(error.status + ' : ' + error.statusText);
        }
      );
  }

  /**
   * Manage account creation.
   */
  onSubmitCreate() {
    if (this.createAccForm.invalid) {
      return;
    }

    let username = this.createAccForm.controls.username.value;
    let password = this.createAccForm.controls.password.value;
    let firstname = this.createAccForm.controls.firstname.value;
    let lastname = this.createAccForm.controls.lastname.value;

    this.userAccServ
      .createUserAccount(username, password, firstname, lastname)
      .pipe(untilDestroyed(this))
      .subscribe(
        () => {
          // account created.
          this.resetForms();
          this.router.navigate(['login', { status: 'createsuccess' }]);
        },
        e => console.log(e)
      );
  }

  /**
   * Reset state of forms in the page.
   */
  resetForms() {
    this.loginForm.reset();
    this.createAccForm.reset();
  }

  logOut() {
    this.authServ
      .logout()
      .pipe(untilDestroyed(this))
      .subscribe(
        () => {
          this.router.navigate(['login']);
        },
        error => {
          console.log('Error login out' + error);
          alert(error.status + ' : ' + error.statusText);
        }
      );
  }

  showLoginForm() {
    this.showLogin = true;
  }

  showCreateAccForm() {
    this.showLogin = false;
  }

  ngOnDestroy() {}
}
