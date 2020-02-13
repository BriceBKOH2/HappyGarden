import { Component, OnInit } from '@angular/core';
import { LibraryService } from '../service/library.service';
import { Plant } from 'src/app/classes/plant';

@Component({
  selector: 'app-library-list',
  templateUrl: './library-list.component.html',
  styleUrls: ['./library-list.component.scss']
})
export class LibraryListComponent implements OnInit {
  plants: Plant[] = [];

  constructor(private libraryService: LibraryService) {}

  ngOnInit() {
    this.libraryService.findAllPlants().subscribe(response => {
      console.log(response);
      this.plants = response;
    });
  }
}
