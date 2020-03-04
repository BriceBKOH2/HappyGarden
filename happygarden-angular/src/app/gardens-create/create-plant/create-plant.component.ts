import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { UserAccount } from 'src/app/classes/user-account';
import { Plant } from 'src/app/classes/plant';
import { AuthenticateService } from 'src/app/authenticate/services/authenticate.service';
import { CreateService } from '../services/create.service';
import { ActivatedRoute, Router } from '@angular/router';
import { untilDestroyed } from 'ngx-take-until-destroy';
import { switchMap } from 'rxjs/operators';
import { PlantUser } from 'src/app/classes/plant-user.model';
import { LibraryService } from 'src/app/library/service/library.service';
import { PlantingArea } from 'src/app/classes/planting-area';
import { Slot } from 'src/app/classes/slot';

@Component({
  selector: 'app-create-plant',
  templateUrl: './create-plant.component.html',
  styleUrls: ['./create-plant.component.scss']
})
export class CreatePlantComponent implements OnInit {
  searchPlantForm = new FormGroup({
    plantName: new FormControl('')
  });
  plants: Plant[] = [];
  plantsUser: PlantUser[] = [];

  userAccount: UserAccount;
  addPlants: Plant[] = [];
  addPlantsUser: PlantUser[] = [];
  currentPlantingArea: PlantingArea;

  constructor(
    private libraryService: LibraryService,
    private authServ: AuthenticateService,
    private createServ: CreateService,
    private activatedRoute: ActivatedRoute,
    private router: Router
  ) {
    this.userAccount = new UserAccount();
  }

  ngOnInit() {
    this.libraryService.findAllPlants().subscribe(response => {
      this.plants = response;
    });

    this.authServ.user$.subscribe(userAuth =>
      this.libraryService
        .findByCreator(userAuth.nickname)
        .subscribe(response => {
          console.log(response);
          this.plantsUser = response;
        })
    );

    this.createServ
      .getPlantingArea(this.activatedRoute.snapshot.params['id'])
      .pipe(untilDestroyed(this))
      .subscribe(response => (this.currentPlantingArea = response));

    this.addPlants = [];
    this.addPlantsUser = [];
  }

  searchPlant() {
    console.log('search plant');
    this.libraryService
      .searchByCommonNameOrScientificName(this.searchPlantForm.value.plantName)
      .subscribe(response => (this.plants = response));

    this.authServ.user$.subscribe(userAuth =>
      this.libraryService
        .searchByCommonNameOrScientificNameAndCreator(
          this.searchPlantForm.value.plantName,
          userAuth.nickname
        )
        .subscribe(response => {
          console.log(userAuth.nickname);
          this.plantsUser = response;
        })
    );
  }

  selectPlant(plant: Plant) {
    console.log('plant : ' + plant.id);
    if (!this.addPlants.includes(plant)) {
      this.addPlants.push(plant);
    } else {
      var index = this.addPlants.indexOf(plant);
      this.addPlants.splice(index, 1);
    }
    console.log(this.addPlants);
  }

  selectPlantUser(plant: PlantUser) {
    console.log('plant : ' + plant.id);
    if (!this.addPlantsUser.includes(plant)) {
      this.addPlantsUser.push(plant);
    } else {
      var index = this.addPlantsUser.indexOf(plant);
      this.addPlantsUser.splice(index, 1);
    }

    console.log(this.addPlantsUser);
  }

  addPlantsToPlantingArea() {
    var idPlantingArea = this.activatedRoute.snapshot.params['id'];
    var arrayPlantsPlantsUser = this.addPlants.concat(this.addPlantsUser);
    var slot: Slot;

    arrayPlantsPlantsUser.forEach(plant =>
      this.createServ
        .postSlotWithPlant(plant, this.currentPlantingArea)
        .pipe(untilDestroyed(this))
        .subscribe(response => (slot = response))
    );

    if (arrayPlantsPlantsUser.length != 0) {
      this.router.navigate(['/gardens']);
    }
  }

  plantUserIsPresent(plantUser: PlantUser): Boolean {
    console.log('test present : ' + this.addPlantsUser.includes(plantUser));
    return this.addPlantsUser.includes(plantUser);
  }

  plantIsPresent(plant: Plant): Boolean {
    console.log('test present : ' + this.addPlants.includes(plant));
    return this.addPlants.includes(plant);
  }

  onSubmit(formData: FormData): void {}

  ngOnDestroy() {}
}
