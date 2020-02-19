import { Component, OnInit } from '@angular/core';
import { PlantAPITrefleIoService } from 'src/app/services/plantAPITrefle_io/plant-apitrefle-io.service';
import { Plant } from 'src/app/classes/plant';

@Component({
  selector: 'app-plant-api',
  templateUrl: './plant-api.component.html',
  styleUrls: ['./plant-api.component.scss']
})
export class PlantApiComponent implements OnInit {
  plant: any = {};
  constructor(private plantApiServ: PlantAPITrefleIoService) {}

  ngOnInit() {
    this.plantApiServ
      .getKingdom(1)
      .subscribe(response => (this.plant = response));
  }
}
