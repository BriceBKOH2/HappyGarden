import { Component, OnInit } from '@angular/core';
import { MyGardensComponent } from '../my-gardens.component';
import { FileService } from 'src/app/services/file/file.service';

@Component({
  selector: 'app-body-plant',
  templateUrl: './body-plant.component.html',
  styleUrls: ['./body-plant.component.scss']
})
export class BodyPlantComponent implements OnInit {
  constructor(
    public myGardens: MyGardensComponent,
    private fileService: FileService
  ) {}

  ngOnInit() {}
}
