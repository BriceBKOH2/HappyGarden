import { Component, OnInit, OnDestroy } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthenticateService } from '../authenticate/services/authenticate.service';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit, OnDestroy {

  private subscription: Subscription;
  loginForm: FormGroup;
  invalidLogin = false;

  constructor(
    private formBuilder: FormBuilder,
    public authServ: AuthenticateService,
    private router: Router
  ) {}

  ngOnInit() {
    this.loginForm = this.formBuilder.group({
      username: ['', Validators.compose([Validators.required])],
      password: ['', Validators.required]
    });
  }

  onSubmit() {
    if (this.loginForm.invalid) {
      return;
    }
    let username = this.loginForm.controls.username.value;
    let password = this.loginForm.controls.password.value;

    this.subscription = this.authServ.login(username, password).subscribe(
      () => {
        this.router.navigate(['userAccount']);
      },
      error => {
        this.invalidLogin = true;
        console.log(error);
        alert(error.status + ' : ' + error.statusText);
      }
    );
  }

  logOut() {
    this.authServ.logout().subscribe(
      () => {
        this.router.navigate(['login']);
      },
      error => {
        console.log('Error login out' + error);
        alert(error.status + ' : ' + error.statusText);
      }
    );
  }

  ngOnDestroy() {
    // throw error when navigating to other pages
    // this.subscription.unsubscribe();
  }
}
