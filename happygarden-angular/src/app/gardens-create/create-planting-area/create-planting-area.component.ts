import { Component, OnInit } from '@angular/core';
import { FormGroup, Validators, FormControl } from '@angular/forms';
import { UserAccount } from 'src/app/classes/user-account';
import { PlantingArea } from 'src/app/classes/planting-area';
import { AuthenticateService } from 'src/app/authenticate/services/authenticate.service';
import { CreateService } from '../services/create.service';
import { ActivatedRoute, Router } from '@angular/router';
import { untilDestroyed } from 'ngx-take-until-destroy';
import { MatRadioChange } from '@angular/material';
import { switchMap } from 'rxjs/operators';

@Component({
  selector: 'app-create-planting-area',
  templateUrl: './create-planting-area.component.html',
  styleUrls: ['./create-planting-area.component.scss']
})
export class CreatePlantingAreaComponent implements OnInit {
  createPlantingAreaForm: FormGroup;
  userAccount: UserAccount;
  newPlantingArea: PlantingArea | any;
  plantingAreaName: string;
  typeZDP: string;
  types: string[] = ['Pot', 'Parcelle'];
  potLocation: string;
  locations: string[] = ['intérieur', 'extérieur'];
  potSelected: boolean;
  formIsSubmitted = false;

  constructor(
    private authServ: AuthenticateService,
    private createServ: CreateService,
    private activatedRoute: ActivatedRoute,
    private router: Router
  ) {
    this.userAccount = new UserAccount();
  }

  get f() {
    return this.createPlantingAreaForm.controls;
  }

  ngOnInit() {
    this.createPlantingAreaForm = new FormGroup(
      {
        plantingAreaName: new FormControl('', Validators.required),
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
    this.newPlantingArea = new PlantingArea();
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
    if (this.createPlantingAreaForm.valid) {
      const values = this.createPlantingAreaForm.getRawValue();
      console.log(values);

      console.log(this.f.plantingAreaName.value);
      this.newPlantingArea.name = this.f.plantingAreaName.value;

      if (this.f.typeZDP.value === 'Pot') {
        this.newPlantingArea.type = 'pot';
        if (this.f.potLocation.value === 'intérieur') {
          console.log;
          this.newPlantingArea.interior = true;
        } else {
          this.newPlantingArea.interior = false;
        }
      } else if (this.f.typeZDP.value === 'Parcelle') {
        this.newPlantingArea.type = 'parcel';
      }
      // this.newPlantingArea.type = this.f.plantingAreaName.value;

      console.log('garden id: ' + this.activatedRoute.snapshot.params['id']);
      this.createServ
        .getGarden(this.activatedRoute.snapshot.params['id'])
        .pipe(
          untilDestroyed(this),
          switchMap(garden => {
            this.newPlantingArea.garden = { id: garden.id };
            return this.createServ.postPlantingArea(this.newPlantingArea);
          })
        )
        .subscribe(response => {
          console.log('rr', response);
          this.formIsSubmitted = false;
        });

      // this.router.navigate(['/gardens']);
      // this.createServ
      //   .postPlantingArea(this.newPlantingArea)
      //   .pipe(untilDestroyed(this))
      //   .subscribe();
      // this.router.navigate(['/gardens']);
    }
  }

  ngOnDestroy() {}
}
