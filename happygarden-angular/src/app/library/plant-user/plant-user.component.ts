import { Component, OnInit, OnDestroy } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';
import { AuthenticateService } from 'src/app/authenticate/services/authenticate.service';
import { LibraryService } from 'src/app/library/service/library.service'
import { GrowthRate } from 'src/app/enums/growth-rate.enum';
import { asLiteral } from '@angular/compiler/src/render3/view/util';
import { PlantUser } from 'src/app/classes/plant-user.model';
import { Season } from 'src/app/enums/season.enum';

@Component({
  selector: 'app-plant-user',
  templateUrl: './plant-user.component.html',
  styleUrls: ['./plant-user.component.scss']
})
export class PlantUserComponent implements OnInit, OnDestroy {

  createFormPlantUser: FormGroup;
  param: string;
  newPlantUser;
  growthRates = Object.keys(GrowthRate).filter(type => typeof GrowthRate[type as any] === 'number');
  seasons = Object.keys(Season).filter(type => typeof Season[type as any] === 'number');

  constructor(
    public authServ: AuthenticateService,
    private plantUserServ: LibraryService,
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
      commonName: ['', [Validators.required]],
      scientificname: [''],
      familyCommonName: [''],
      toxicity: [''],
      matureHeight: [''],
      lifeSpan: [''],
      image: [''],
      bloomPeriod: [''],
      growthRate: [this.growthRates[0]]
    }
    )
    this.resetPlant()
  }

  onSubmitPlantCreate() {
    if (this.createFormPlantUser.invalid) {
      return;
    }
    this.newPlantUser.commonName = this.createFormPlantUser.controls.commonName.value;
    this.newPlantUser.scientificName = this.createFormPlantUser.controls.scientificname.value;
    this.newPlantUser.familyCommonName = this.createFormPlantUser.controls.familyCommonName.value;
    this.newPlantUser.toxicity = this.createFormPlantUser.controls.toxicity.value;
    this.newPlantUser.matureHeight = this.createFormPlantUser.controls.matureHeight.value;
    this.newPlantUser.lifeSpan = this.createFormPlantUser.controls.lifeSpan.value;
    this.newPlantUser.image = this.createFormPlantUser.controls.image.value;
    this.newPlantUser.bloomPeriod = this.createFormPlantUser.controls.bloomPeriod.value;
    this.newPlantUser.growthRate = this.createFormPlantUser.controls.growthRate.value;
    this.authServ.user$.subscribe(user => {this.newPlantUser.creator = user.nickname;
      console.log(this);
      this.sendNewPlantUser(this.newPlantUser)})
  }

  sendNewPlantUser(newPlantUser: PlantUser) {
    this.plantUserServ.createPlantUser(newPlantUser).subscribe(
      (response) => {
        // account created.
        this.resetForms();
        this.resetPlant();
        this.router.navigate(['libraryList', { status: 'createsuccess'}]);
        console.log(response)
      },
      (e) => (console.log(e))
    );
  }

  updateSeasons(seasonUnit: Season) {
    if(!this.newPlantUser.seasons.includes(seasonUnit)) {
      this.newPlantUser.seasons.push(seasonUnit)
    }
    else {
      const index = this.newPlantUser.seasons.indexOf(seasonUnit);
      this.newPlantUser.seasons.splice(index,1)
    }
  }

  resetForms() {
    this.createFormPlantUser.reset();
  }

  resetPlant() {
    this.newPlantUser = new PlantUser();
    this.newPlantUser.seasons = new Array<Season>();
  }
  ngOnDestroy() {
    // throw error when navigating to other pages
    // this.subscription.unsubscribe();
  }
}
