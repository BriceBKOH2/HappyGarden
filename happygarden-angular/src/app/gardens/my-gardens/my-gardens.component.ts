import { Component, OnInit } from '@angular/core';
import { Garden } from 'src/app/classes/garden';
import { GardenListService } from 'src/app/gardens/service/garden-list.service';
import { UserAccount } from 'src/app/classes/user-account';
import { PlantingArea } from 'src/app/classes/planting-area';
import { Plant } from 'src/app/classes/plant';
import { Slot } from 'src/app/classes/slot';
import { Observable } from 'rxjs';
import { UserAccountRequestService } from 'src/app/services/userAccountRequest/user-account-request.service';
import { AuthenticateService } from 'src/app/authenticate/services/authenticate.service';

@Component({
  selector: 'app-my-gardens',
  templateUrl: './my-gardens.component.html',
  styleUrls: ['./my-gardens.component.scss']
})
export class MyGardensComponent implements OnInit {
  gardens$: Observable<Garden[]>;
  userAccount: UserAccount;
  currentGarden: Garden;
  currentPlantingArea: PlantingArea;
  currentSlot: Slot;
  currentPlant: Plant;
  plant: Plant;

  constructor(
    private gardenListService: GardenListService,
    private userAccServ: UserAccountRequestService,
    private authServ: AuthenticateService
  ) {}

  ngOnInit() {
    this.currentGarden = new Garden();
    this.currentPlantingArea = new PlantingArea();
    this.currentSlot = new Slot();
    this.currentPlant = new Plant();
    this.plant = new Plant();

    // this.gardens$ = this.userAccServ.getGardens();

    let id: number;
    this.authServ.user$.subscribe(response => (id = response.id));
    this.gardens$ = this.userAccServ.getGardens(id);
  }

  showGardens() {
    this.currentGarden = new Garden();
    this.currentPlantingArea = new PlantingArea();
    this.currentSlot = new Slot();
    this.currentPlant = new Plant();
  }

  selectGarden(garden: Garden) {
    if (!this.currentGarden || this.currentGarden !== garden) {
      this.currentGarden = garden;
      this.currentPlantingArea = new PlantingArea();
      this.currentSlot = new Slot();
      this.currentPlant = new Plant();
      console.log('garden first if ' + garden.id);
    } else {
      this.currentPlantingArea = new PlantingArea();
      this.currentSlot = new Slot();
      this.currentPlant = new Plant();
      console.log('garden else');
    }
    console.log(
      'SelectGarden - gardenId :' +
        this.currentGarden.id +
        ' plantingAreaId :' +
        this.currentPlantingArea.id +
        ' plantId :' +
        this.currentPlant.id
    );
  }

  selectPlantingArea(event, plantingArea: PlantingArea) {
    console.log(event);
    event.stopPropagation();
    if (
      !this.currentPlantingArea ||
      this.currentPlantingArea !== plantingArea
    ) {
      this.currentPlantingArea = plantingArea;
      this.currentPlant = new Plant();
      this.currentSlot = new Slot();
    } else {
      this.currentPlant = new Plant();
      this.currentSlot = new Slot();
    }
    console.log(
      'SelectPlantingArea - gardenId :' +
        this.currentGarden.id +
        ' plantingAreaId :' +
        this.currentPlantingArea.id +
        ' plantId :' +
        this.currentPlant.id
    );
  }

  selectPlant(event, slot: Slot) {
    console.log(event);
    event.stopPropagation();
    if (!this.currentPlant.id || this.currentPlant.id !== slot.plant.id) {
      this.currentSlot = slot;
      this.currentPlant = slot.plant;
    }
    // else {
    //   this.currentPlant = new Plant;
    // }
    console.log(
      'SelectPlantingArea - gardenId :' +
        this.currentGarden.id +
        ' plantingAreaId :' +
        this.currentPlantingArea.id +
        ' plantId :' +
        this.currentPlant.id
    );
  }
}
