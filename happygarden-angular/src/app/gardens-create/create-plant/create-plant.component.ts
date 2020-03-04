import { Component, OnInit } from '@angular/core';
import {
  FormGroup,
  FormBuilder,
  FormControl,
  Validators
} from '@angular/forms';
import { UserAccount } from 'src/app/classes/user-account';
import { Garden } from 'src/app/classes/garden';
import { PlantingArea } from 'src/app/classes/planting-area';
import { Plant } from 'src/app/classes/plant';
import { AuthenticateService } from 'src/app/authenticate/services/authenticate.service';
import { CreateService } from '../services/create.service';
import { ActivatedRoute, Router } from '@angular/router';
import { untilDestroyed } from 'ngx-take-until-destroy';
import { switchMap, map } from 'rxjs/operators';
import { MatRadioChange } from '@angular/material';
import { PlantUser } from 'src/app/classes/plant-user.model';
import { LibraryService } from 'src/app/library/service/library.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-create-plant',
  templateUrl: './create-plant.component.html',
  styleUrls: ['./create-plant.component.scss']
})
export class CreatePlantComponent implements OnInit {
  createPlantForm: FormGroup;
  userAccount: UserAccount;
  newPlant: Plant | any;
  plantName: string;
  types: string[] = ['Bibliothèque', 'Mes plantes personalisées'];
  currentPlantingArea: PlantingArea;
  formIsSubmitted = false;

  plants$: Observable<Plant[]>;
  plantsUser$: Observable<PlantUser[]>;
  plantsUser: PlantUser[];

  searchPlantFrom = new FormGroup({
    plantName: new FormControl('')
  });

  constructor(
    private formBuilder: FormBuilder,
    private libraryService: LibraryService,
    private authServ: AuthenticateService,
    private createServ: CreateService,
    private activatedRoute: ActivatedRoute,
    private router: Router
  ) {
    this.userAccount = new UserAccount();
  }

  get f() {
    return this.createPlantForm.controls;
  }

  ngOnInit() {
    this.plants$ = this.libraryService.findAllPlants();

    this.authServ.user$.subscribe(response => (this.userAccount = response));

    // this.plantsUser$ = this.authServ.user$.pipe(
    //   map(userAuth => userAuth.nickname),
    //   switchMap(nickname => {
    //     console.log(nickname);
    //     return this.libraryService.findByCreator(nickname);
    //   })
    // );

    this.authServ.user$.subscribe(userAuth =>
      this.libraryService
        .findByCreator(userAuth.nickname)
        .subscribe(response => {
          console.log(response);
          this.plantsUser = response;
        })
    );

    console.log();

    this.newPlant = new Plant();
    this.currentPlantingArea = new PlantingArea();
  }

  searchPlant() {
    this.plants$ = this.libraryService.searchByCommonNameOrScientificName(
      this.searchPlantFrom.value.plantName
    );
  }

  radioTypeChange($event: MatRadioChange) {
    // console.log($event.source.name, $event.value);
    // if ($event.source.name === 'radioTypeZDP') {
    //   console.log(this.f.typeZDP);
    //   this.potSelected = !this.potSelected;
    //   console.log(this.potSelected);
    // }
    // if ($event.source.name === 'radioPot') {
    //   console.log(this.f.potLocation);
    // }
  }

  onSubmit(formData: FormData): void {}

  ngOnDestroy() {}
}
