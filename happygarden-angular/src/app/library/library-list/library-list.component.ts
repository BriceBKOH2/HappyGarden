import { Component, OnInit } from '@angular/core';
import { LibraryService } from '../service/library.service';
import { Plant } from 'src/app/classes/plant';
import { FormControl, FormGroup } from '@angular/forms';
import { AuthenticateService } from 'src/app/authenticate/services/authenticate.service';

@Component({
  selector: 'app-library-list',
  templateUrl: './library-list.component.html',
  styleUrls: ['./library-list.component.scss']
})
export class LibraryListComponent implements OnInit {
  plants: Plant[] = [];

  searchPlantFrom = new FormGroup({
    plantName: new FormControl()
  });

  constructor(private libraryService: LibraryService) {}

  ngOnInit() {
    this.libraryService.findAllPlants().subscribe(response => {
      console.log(response);
      this.plants = response;
    });
  }

  searchPlant() {
    this.libraryService
      .searchByCommonNameOrScientificName(this.searchPlantFrom.value.plantName)
      .subscribe(response => (this.plants = response));
  }
}
