import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { RequestService } from 'src/app/services/request/request.service';
import { Garden } from 'src/app/classes/garden';
import { Observable } from 'rxjs';
import { PlantingArea } from 'src/app/classes/planting-area';
import { Plant } from 'src/app/classes/plant';
import { Slot } from 'src/app/classes/slot';

@Injectable({
  providedIn: 'root'
})
export class CreateService {
  constructor(
    private httpClient: HttpClient,
    private request: RequestService
  ) {}

  get endPointGarden(): string {
    return this.request.endPoint + '/Garden';
  }

  get endPointPlantingArea(): string {
    return this.request.endPoint + '/PlantingArea';
  }

  get endPointSlot(): string {
    return this.request.endPoint + '/Slot';
  }

  postGarden(garden: Garden): Observable<Garden> {
    console.log('postGarden service');
    return this.httpClient.post<Garden>(`${this.endPointGarden}`, garden);
  }

  getGarden(id: number): Observable<Garden> {
    console.log('getGarden id: ' + id);
    return this.httpClient.get<Garden>(`${this.endPointGarden}/${id}`);
  }

  getPlantingArea(id: number): Observable<PlantingArea> {
    console.log('getPlantingArea id: ' + id);
    return this.httpClient.get<PlantingArea>(
      `${this.endPointPlantingArea}/${id}`
    );
  }

  postPlantingArea(plantingArea: PlantingArea): Observable<PlantingArea> {
    console.log('postPlantingArea service');
    return this.httpClient.post<PlantingArea>(
      `${this.endPointPlantingArea}`,
      plantingArea
    );
  }

  /*add a slot to plantingArea and add a plant to the slot
   */
  postSlotWithPlant(
    plant: any,
    currentPlantingArea: PlantingArea
  ): Observable<Slot> {
    console.log('postPlant service');
    var slot = new Slot();
    var date = new Date();

    slot.date = date;
    slot.plant = plant;
    slot.plantingArea = currentPlantingArea;
    console.log(
      'slot plantingArea: ' +
        slot.plantingArea.id +
        ' slot date ' +
        slot.date +
        'slot plant: ' +
        slot.plant
    );
    console.log(slot);

    return this.httpClient.post<Slot>(`${this.endPointSlot}`, slot);
  }

  // /*add a slot to plantingArea and add a plant to the slot
  //  */
  // postSlotsWithPlants(
  //   plants: any[],
  //   idPlantingArea: number
  // ): Observable<Slot[]> {
  //   console.log('postPlant service');
  //   var slots: Slot[] = [];
  //   var date = new Date();
  //   plants.forEach(plant => {
  //     var slot = new Slot();
  //     var plantingArea = new PlantingArea();
  //     plantingArea.id = idPlantingArea;
  //     slot.date = date;
  //     slot.plant = plant;
  //     slot.plantingArea = plantingArea;
  //     slots.push(slot);
  //     console.log(
  //       'slot plantingArea: ' +
  //         slot.plantingArea.id +
  //         ' slot date ' +
  //         slot.date +
  //         'slot plant: ' +
  //         slot.plant
  //     );
  //     console.log(slots);
  //   });

  //   return this.httpClient.post<Slot[]>(`${this.endPointSlot}`, slots);
  // }
}
