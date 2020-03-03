import { Component, OnInit } from '@angular/core';
import { MyGardensComponent } from '../my-gardens.component';
import { Garden } from 'src/app/classes/garden';
import { Plant } from 'src/app/classes/plant';

@Component({
  selector: 'app-body-planting-area',
  templateUrl: './body-planting-area.component.html',
  styleUrls: ['./body-planting-area.component.scss']
})
export class BodyPlantingAreaComponent implements OnInit {
  constructor(public myGardens: MyGardensComponent) {}

  ngOnInit() {}
}
