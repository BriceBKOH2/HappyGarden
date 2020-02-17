import { Component, OnInit } from '@angular/core';
import { MyGardensComponent } from '../my-gardens.component';

@Component({
  selector: 'app-garden-sidebar',
  templateUrl: './garden-sidebar.component.html',
  styleUrls: ['./garden-sidebar.component.scss']
})
export class GardenSidebarComponent implements OnInit {
  constructor(private myGardens: MyGardensComponent) {}

  ngOnInit() {}
}
