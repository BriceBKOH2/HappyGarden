import { Component, OnInit } from '@angular/core';
import { MyGardensComponent } from '../my-gardens.component';
import { PlantingArea } from 'src/app/classes/planting-area';
import { FileUpDownloadComponent } from 'src/app/file/file-up-download/file-up-download.component';
import { GardenService } from '../../services/garden.service';
import { untilDestroyed } from 'ngx-take-until-destroy';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-body-garden',
  templateUrl: './body-garden.component.html',
  styleUrls: ['./body-garden.component.scss']
})
export class BodyGardenComponent implements OnInit {
  // private plantsNb: Number = 0;
  constructor(
    public myGardens: MyGardensComponent,
    private gardenServ: GardenService
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

  countPlants(id: Number): Observable<Number> {
    let plantsNb$: Observable<Number>;
    // plantsNb$ = this.gardenServ.countPlants(id);
    console.log(plantsNb$);
    return plantsNb$;
    // .pipe(untilDestroyed(this))
    // .subscribe(response => {
    //   this.plantsNb = response;
    //   // console.log('plantsNb : ' + this.plantsNb + ' PA id :' + id);
    // });

    // console.log('plantsNb : ' + this.plantsNb + ' PA id :' + id);
  }

  ngOnDestroy() {}
}
