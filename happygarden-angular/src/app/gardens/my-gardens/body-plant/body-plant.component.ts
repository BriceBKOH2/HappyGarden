import { Component, OnInit } from '@angular/core';
import { MyGardensComponent } from '../my-gardens.component';

@Component({
  selector: 'app-body-plant',
  templateUrl: './body-plant.component.html',
  styleUrls: ['./body-plant.component.scss']
})
export class BodyPlantComponent implements OnInit {
  private plantImgUrl: string;
  private inconeUrl: string;

  constructor(public myGardens: MyGardensComponent) {
    this.plantImgUrl =
      'http://192.168.1.11:8082/happygarden/api/downloadFile?type=plants';
    this.inconeUrl =
      'http://192.168.1.11:8082/happygarden/api/downloadFile?type=icones';
  }

  ngOnInit() {}
}
