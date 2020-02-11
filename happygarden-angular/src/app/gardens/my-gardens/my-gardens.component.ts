import { Component, OnInit } from '@angular/core';
import { Garden } from 'src/app/classes/garden';
import { GardenListService } from 'src/app/services/garden-list.service';
import { UserAccount } from 'src/app/classes/user-account';

@Component({
  selector: 'app-my-gardens',
  templateUrl: './my-gardens.component.html',
  styleUrls: ['./my-gardens.component.scss']
})
export class MyGardensComponent implements OnInit {
  gardens: Garden[] = [];
  userAccount: UserAccount;
  plantingAreaId: number;
  gardenId: number;
  plantId: number;

  constructor(private gardenListService: GardenListService) {}

  ngOnInit() {
    this.gardenId = 0;
    this.plantingAreaId = 0;
    this.plantId = 0;

    this.gardenListService.getGardens(5).subscribe(response => {
      this.gardens = response;
    });
  }

  selectGarden(gardenId: number, plantingAreaId: number) {
    if (this.gardenId === 0 || this.gardenId !== gardenId) {
      this.gardenId = gardenId;
       this.plantingAreaId = 0;
    this.plantId = 0;
    } else {
      this.gardenId = 0;
    }
    console.log(
      'SelectGarden - gardenId :' +
        this.gardenId +
        ' plantingAreaId :' +
        this.plantingAreaId
    );
  }

  selectPlantingArea(event, id: number) {
    console.log(event);
    event.stopPropagation();
    if (this.plantingAreaId === 0 || this.plantingAreaId !==id) {
      this.plantingAreaId = id;
    } else {
      this.plantingAreaId = 0;
    }
    console.log(
      'SelectPlantingArea - gardenId :' +
        this.gardenId +
        ' plantingAreaId :' +
        this.plantingAreaId
    );
  }

  selectPlant(event, id: number) {
    console.log(event);
    event.stopPropagation();
    if (this.plantId === 0 || this.plantId !==id) {
      this.plantId = id;
    } else {
      this.plantId = 0;
    }
    console.log(
      'SelectPlantingArea - gardenId :' +
        this.gardenId +
        ' plantingAreaId :' +
        this.plantingAreaId +
        ' plantId :' +
        this.plantId
    );
  }
}
