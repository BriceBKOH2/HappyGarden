import { Component, OnInit, OnDestroy } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';
import { AuthenticateService } from 'src/app/authenticate/services/authenticate.service';
import { Subscription } from 'rxjs';
import { UserAccountRequestService } from 'src/app/services/userAccountRequest/user-account-request.service';
import { LibraryService } from 'src/app/library/service/library.service'

@Component({
  selector: 'app-plant-user',
  templateUrl: './plant-user.component.html',
  styleUrls: ['./plant-user.component.scss']
})
export class PlantUserComponent implements OnInit, OnDestroy {

  createFormPlantUser: FormGroup;
  param: string;

  constructor(
    public authServ: AuthenticateService,
    private plantUserServ: LibraryService,
    private userAccServ: UserAccountRequestService,
    private formBuilder: FormBuilder,
    private router: Router,
    private activatedRoute: ActivatedRoute
  ) {

    this.activatedRoute.paramMap.subscribe(
      (p) => {this.param = p.get('status')}
    );

  }

  ngOnInit() {
    this.createFormPlantUser = this.formBuilder.group({
      scientificname: ['', Validators.compose([Validators.required, Validators.minLength(4)])],
      commonName: ['', [Validators.required]],
      familyCommonName: ['', [Validators.required]],
      toxicity: ['', Validators.required],
      matureHeight: ['', [Validators.required]],
      lifeSpan: ['', [Validators.required]],
      image: ['', [Validators.required]],
      bloomPeriod: ['', [Validators.required]],
      growthRate: ['', [Validators.required]]
    }
    )

  }

  onSubmitPlantCreate() {
    if (this.createFormPlantUser.invalid) {
      return;
    }

    let scientificname = this.createFormPlantUser.controls.scientificname.value;
    let commonName = this.createFormPlantUser.controls.commonName.value;
    let familyCommonName = this.createFormPlantUser.controls.familyCommonName.value;
    let toxicity = this.createFormPlantUser.controls.toxicity.value;
    let matureHeight = this.createFormPlantUser.controls.matureHeight.value;
    let lifeSpan = this.createFormPlantUser.controls.lifeSpan.value;
    let image = this.createFormPlantUser.controls.image.value;
    let bloomPeriod = this.createFormPlantUser.controls.bloomPeriod.value;
    let growthRate = this.createFormPlantUser.controls.growthRate.value;
    console.log("appel du service...")
    this.plantUserServ.createPlantUser(scientificname, commonName, familyCommonName, toxicity,
      matureHeight, lifeSpan, image, bloomPeriod).subscribe(
      () => {
        // account created.
        this.resetForms();
        this.router.navigate(['login', { status: 'createsuccess'}]);
      },
      (e) => (console.log(e))
    );
  }

  resetForms() {
    this.createFormPlantUser.reset();
  }

  ngOnDestroy() {
    // throw error when navigating to other pages
    // this.subscription.unsubscribe();
  }
}
