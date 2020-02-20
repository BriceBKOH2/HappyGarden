import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { AuthenticateService } from 'src/app/authenticate/services/authenticate.service';
import { UserAccount } from 'src/app/classes/user-account';
import { Observable } from 'rxjs';
import { Garden } from 'src/app/classes/garden';
import { CreateService } from '../services/create.service';

@Component({
  selector: 'app-create-garden',
  templateUrl: './create-garden.component.html',
  styleUrls: ['./create-garden.component.scss']
})
export class CreateGardenComponent implements OnInit {
  createGardenForm: FormGroup;
  userAccount: UserAccount;
  newGarden: Garden;
  gardenName: string;

  constructor(
    private formBuilder: FormBuilder,
    private authServ: AuthenticateService,
    private createServ: CreateService
  ) {}

  get f() {
    return this.createGardenForm.controls;
  }

  ngOnInit() {
    this.createGardenForm = this.formBuilder.group({
      gardenName: ['', Validators.required]
    });
    this.authServ.user$.subscribe(response => (this.userAccount = response));
  }

  onSubmit(formData: FormData) {
    this.gardenName = this.f.gardenName.value;
    this.newGarden = new Garden(this.gardenName);
    this.newGarden.user = this.userAccount;
    console.log('this.gardenName');
    this.createServ.postGarden(this.newGarden);
  }
}
