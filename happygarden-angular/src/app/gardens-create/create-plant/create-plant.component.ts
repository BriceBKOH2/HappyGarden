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
import { switchMap } from 'rxjs/operators';
import { MatRadioChange } from '@angular/material';

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
  typeZDP: string;
  types: string[] = ['Pot', 'Parcelle'];
  potLocation: string;
  locations: string[] = ['intérieur', 'extérieur'];
  potSelected: boolean;
  currentPlantingArea: PlantingArea;
  formIsSubmitted = false;

  constructor(
    private formBuilder: FormBuilder,
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
    this.createPlantForm = new FormGroup(
      {
        plantName: new FormControl('', Validators.required),
        typeZDP: new FormControl('Pot', Validators.required),
        potLocation: new FormControl('intérieur')
      },
      [
        (formGroup: FormGroup) => {
          if (
            formGroup &&
            formGroup.get('typeZDP') &&
            formGroup.get('typeZDP').value === 'Pot'
          ) {
            if (!formGroup.get('potLocation').value) {
              return { potLocationUndefined: true };
            }
          }
        }
      ]
    );
    this.authServ.user$.subscribe(response => (this.userAccount = response));
    this.potSelected = true;
    this.newPlant = new Plant();
    this.currentPlantingArea = new PlantingArea();
  }

  radioTypeChange($event: MatRadioChange) {
    console.log($event.source.name, $event.value);
    if ($event.source.name === 'radioTypeZDP') {
      console.log(this.f.typeZDP);
      this.potSelected = !this.potSelected;
      console.log(this.potSelected);
    }
    if ($event.source.name === 'radioPot') {
      console.log(this.f.potLocation);
    }
  }

  onSubmit(formData: FormData): void {
    this.formIsSubmitted = true;
    if (this.createPlantForm.valid) {
      const values = this.createPlantForm.getRawValue();
      console.log(values);

      console.log(this.f.plantingAreaName.value);
      this.newPlant.name = this.f.plantingAreaName.value;

      if (this.f.typeZDP.value === 'Pot') {
        this.newPlant.type = 'pot';
        if (this.f.potLocation.value === 'intérieur') {
          console.log;
          this.newPlant.interior = true;
        } else {
          this.newPlant.interior = false;
        }
      } else if (this.f.typeZDP.value === 'Parcelle') {
        this.newPlant.type = 'parcel';
      }
      // this.newPlantingArea.type = this.f.plantingAreaName.value;

      console.log('garden id: ' + this.activatedRoute.snapshot.params['id']);
      console.log('garden name : ' + this.currentPlantingArea);
      this.createServ
        .getGarden(this.activatedRoute.snapshot.params['id'])
        .pipe(
          untilDestroyed(this),
          switchMap(garden => {
            this.newPlant.garden = { id: garden.id };
            return this.createServ.postPlantingArea(this.newPlant);
          })
        )
        .subscribe(response => {
          console.log('rr', response);
          this.formIsSubmitted = false;
        });

      // this.createServ
      //   .postPlantingArea(this.newPlantingArea)
      //   .pipe(untilDestroyed(this))
      //   .subscribe();
      // this.router.navigate(['/gardens']);
    }
  }

  ngOnDestroy() {}
}
