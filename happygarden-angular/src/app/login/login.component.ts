import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AuthenticateApiService } from '../service/authenticateApi/authenticate-api.service';
import { Router } from '@angular/router';

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
    public authServ: AuthenticateApiService,
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
    const username = this.loginForm.controls.username.value;
    const password = this.loginForm.controls.password.value;

    this.authServ.login(username, password).subscribe(
      () => {
        this.router.navigate(['account']);
      },
      error => {
        this.invalidLogin = true;
        console.log(error);
        alert(error.status + ' : ' + error.statusText);
      }
    );
  }
}
