import { Component, OnInit } from '@angular/core';
import { MyGardensComponent } from '../my-gardens.component';
import { PlantingArea } from 'src/app/classes/planting-area';
import { FileUpDownloadComponent } from 'src/app/file/file-up-download/file-up-download.component';

@Component({
  selector: 'app-body-garden',
  templateUrl: './body-garden.component.html',
  styleUrls: ['./body-garden.component.scss']
})
export class BodyGardenComponent implements OnInit {
  constructor(public myGardens: MyGardensComponent) {}

  ngOnInit() {}

  isInterior(plantingArea: PlantingArea): string {
    if (plantingArea.interior) {
      return 'interieur';
    } else {
      return 'exterieur';
    }
  }
}
