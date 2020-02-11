import { Component, OnInit } from '@angular/core';
import { Garden } from 'src/app/classes/garden';
import { GardenListService } from 'src/app/gardens/service/garden-list.service';
import { UserAccount } from 'src/app/classes/user-account';
import { PlantingArea } from 'src/app/classes/planting-area';
import { Plant } from 'src/app/classes/plant';
import { Slot } from 'src/app/classes/slot';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-my-gardens',
  templateUrl: './my-gardens.component.html',
  styleUrls: ['./my-gardens.component.scss']
})

export class MyGardensComponent implements OnInit {
  gardens$: Observable<Garden[]>;
  userAccount: UserAccount;
  // plantingAreaId: number;
  // gardenId: number;
  // plantId: number;
  currentGarden: Garden;
  currentPlantingArea: PlantingArea;
  currentSlot: Slot;
  currentPlant: Plant;

  constructor(private gardenListService: GardenListService) {}

  ngOnInit() {
    // this.gardenId = 0;
    // this.plantingAreaId = 0;
    // this.plantId = 0;
    this.currentGarden = new Garden;
    this.currentPlantingArea = new PlantingArea;
    this.currentSlot = new Slot;
    this.currentPlant = new Plant;

    this.gardens$ = this.gardenListService.getGardens(5);
  }

  // selectGarden(gardenId: number) {
  //   if (this.gardenId === 0 || this.gardenId !== gardenId) {
  //     this.gardenId = gardenId;
  //      this.plantingAreaId = 0;
  //   this.plantId = 0;
  //   } else {
  //     this.gardenId = 0;
  //   }
  //   console.log(
  //     'SelectGarden - gardenId :' +
  //       this.gardenId +
  //       ' plantingAreaId :' +
  //       this.plantingAreaId
  //   );
  // }

  selectGarden(garden: Garden) {
    if (!this.currentGarden || this.currentGarden !== garden) {
      this.currentGarden = garden;
      this.currentPlantingArea = new PlantingArea;
      this.currentSlot = new Slot
      this.currentPlant = new Plant;
      console.log('garden first if '+ garden.id);
    } else {
      this.currentPlantingArea = new PlantingArea;
      this.currentSlot = new Slot;
      this.currentPlant = new Plant;
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
    if (!this.currentPlantingArea || this.currentPlantingArea !==plantingArea) {
      this.currentPlantingArea = plantingArea;
      this.currentPlant = new Plant;
      this.currentSlot = new Slot;
    } 
    else {
      this.currentPlant = new Plant;
      this.currentSlot = new Slot;
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
    if (!this.currentPlant.id || this.currentPlant.id !==slot.plant.id) {
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
