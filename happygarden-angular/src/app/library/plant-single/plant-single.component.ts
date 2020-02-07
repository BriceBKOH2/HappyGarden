import { Component, OnInit } from '@angular/core';
import { LibraryService } from '../service/library.service';
import { Plant } from 'src/app/classes/plant';

@Component({
  selector: 'app-plant-single',
  templateUrl: './plant-single.component.html',
  styleUrls: ['./plant-single.component.scss']
})
export class PlantSingleComponent implements OnInit {
  constructor(private libraryService: LibraryService) {}

  plant: Plant;
  ngOnInit() {
    this.libraryService.findPlant(/*id plante*/).subscribe(response => {
      console.log(response);
      this.plant = response;
    });
  }
}
