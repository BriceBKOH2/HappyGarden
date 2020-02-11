import { Component, OnInit } from '@angular/core';
import { Garden } from 'src/app/classes/garden';
import { GardenListService } from 'src/app/gardens/service/garden-list.service';
import { UserAccount } from 'src/app/classes/user-account';
import { PlantingArea } from 'src/app/classes/planting-area';
import { Plant } from 'src/app/classes/plant';

@Component({
  selector: 'app-my-gardens',
  templateUrl: './my-gardens.component.html',
  styleUrls: ['./my-gardens.component.scss']
})

export class MyGardensComponent implements OnInit {
  gardens: Garden[] = [];
  userAccount: UserAccount;
  // plantingAreaId: number;
  // gardenId: number;
  // plantId: number;
  currentGarden: Garden;
  currentPlantingArea: PlantingArea;
  currentPlant: Plant;

  constructor(private gardenListService: GardenListService) {}

  ngOnInit() {
    // this.gardenId = 0;
    // this.plantingAreaId = 0;
    // this.plantId = 0;
    this.currentGarden = new Garden;
    this.currentPlantingArea = new PlantingArea;
    this.currentPlant = new Plant;

    this.gardenListService.getGardens(5).subscribe(response => {
      this.gardens = response;
    });
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
    if (this.currentGarden === null || this.currentGarden !== garden) {
      this.currentGarden = garden;
      this.currentPlantingArea = new PlantingArea;
      this.currentPlant = new Plant;
      console.log('garden first if '+ garden.id);
    } else {
      this.currentPlantingArea = new PlantingArea;
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
    if (this.currentPlantingArea === null || this.currentPlantingArea !==plantingArea) {
      this.currentPlantingArea = plantingArea;
      this.currentPlant = new Plant;
    } 
    else {
      this.currentPlant = new Plant;
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

  selectPlant(event, plant: Plant) {
    console.log(event);
    event.stopPropagation();
    if (this.currentPlant === null || this.currentPlant.id !==plant.id) {
      this.currentPlant = plant;
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
        this.currentPlant.id +
         ' test plant === null' 
        
    );
  }
}
