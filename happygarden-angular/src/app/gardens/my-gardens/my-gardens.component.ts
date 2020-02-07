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
  parcelBoolean: boolean;
  plantBoolean: boolean;
  constructor(private gardenListService: GardenListService) {}

  ngOnInit() {
    this.parcelBoolean = false;
    this.plantBoolean = false;

    this.gardenListService.getGardens(5).subscribe(response => {
      this.gardens = response;
    });
  }

  selectGarden() {
    this.parcelBoolean = !this.parcelBoolean;
    console.log('parcel :' + this.parcelBoolean);
  }

  selectPlantingArea() {
    this.plantBoolean = !this.plantBoolean;
    console.log('plant :' + this.plantBoolean);
  }
}
