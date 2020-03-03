import { Component, OnInit } from '@angular/core';
import { MyGardensComponent } from '../my-gardens.component';
import { PlantingArea } from 'src/app/classes/planting-area';
import { FileUpDownloadComponent } from 'src/app/file/file-up-download/file-up-download.component';
import { GardenService } from '../../services/garden.service';
import { untilDestroyed } from 'ngx-take-until-destroy';
import { Observable, forkJoin, BehaviorSubject } from 'rxjs';
import { map } from 'rxjs/operators';
import { HttpClient } from '@angular/common/http';
import { RequestService } from 'src/app/services/request/request.service';

@Component({
  selector: 'app-body-garden',
  templateUrl: './body-garden.component.html',
  styleUrls: ['./body-garden.component.scss']
})
export class BodyGardenComponent implements OnInit {
  // private plantsNb: Number = 0;
  constructor(
    public myGardens: MyGardensComponent,
    private gardenServ: GardenService,
    private httpClient: HttpClient
  ) {}

  ngOnInit() {}

  isInterior(plantingArea: PlantingArea): string {
    console.log('interieur boolean, PA id : ' + plantingArea.id);
    if (plantingArea.interior) {
      return 'interieur';
    } else {
      return 'exterieur';
    }
  }

  // TODO : Debugger pour comprendre pourquoi boucle infinie
  // countPlants(id: Number): Number {
  //   let plantsNb: Number;
  //   this.gardenServ
  //     .countSlots(id)
  //     .pipe(untilDestroyed(this))
  //     .subscribe(response => {
  //       plantsNb = response;
  //       console.log('plantsNb : ' + plantsNb + ' PA id :' + id);
  //     });
  //   return plantsNb;
  // }

  // countPlants(id: Number): Observable<Number> {
  //   return this.gardenServ.countSlots(id);
  // }

  countSlots(plantingArea: PlantingArea): Number {
    return plantingArea.slots.length;
  }

  ngOnDestroy() {}
}
