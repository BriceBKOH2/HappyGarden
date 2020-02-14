import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthenticateService } from '../authenticate/services/authenticate.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
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

    this.authServ.login(username, password).subscribe(
      () => {
        this.router.navigate(['userAccount']);
      },
      error => {
        this.invalidLogin = true;
        console.log(error);
        alert(error.status + ' : ' + error.statusText);
      }
    );

    // this.authServ.login(username, password).subscribe(
    //   () => {
    //     this.router.navigate(['account']);
    //   },
    //   error => {
    //     this.invalidLogin = true;
    //     console.log(error);
    //     alert(error.status + ' : ' + error.statusText);
    //   }
    // );
  }
}
