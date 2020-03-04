import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { RequestService } from 'src/app/services/request/request.service';
import { Observable } from 'rxjs';
import { Garden } from 'src/app/classes/garden';
import { PlantingArea } from 'src/app/classes/planting-area';
import { Plant } from 'src/app/classes/plant';
import { Slot } from 'src/app/classes/slot';

@Injectable({
  providedIn: 'root'
})
export class GardenService {
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

  countPlantingAreas(id: number): Observable<Number> {
    console.log('getGarden id: ' + id);
    return this.httpClient.get<Number>(`${this.endPointGarden}/${id}/count`);
  }

  countSlots(id: Number): Observable<Number> {
    console.log('getPlantingArea id: ' + id);
    return this.httpClient.get<Number>(
      `${this.endPointPlantingArea}/${id}/count`
    );
  }

  deleteGarden(id: number): Observable<Garden> {
    return this.httpClient.delete<Garden>(`${this.endPointGarden}/${id}`);
  }

  deletePlantingArea(id: number): Observable<PlantingArea> {
    return this.httpClient.delete<PlantingArea>(
      `${this.endPointPlantingArea}/${id}`
    );
  }
  deletePlant(id: number): Observable<Slot> {
    return this.httpClient.delete<Slot>(`${this.endPointSlot}/${id}`);
  }
}
