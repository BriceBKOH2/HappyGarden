import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { RequestService } from 'src/app/services/request/request.service';
import { Observable } from 'rxjs';
import { Garden } from 'src/app/classes/garden';

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

  countPlantingAreas(id: number): Observable<Number> {
    console.log('getGarden id: ' + id);
    return this.httpClient.get<Number>(`${this.endPointGarden}/${id}/count`);
  }

  countPlants(id: Number): Observable<Number> {
    console.log('getPlantingArea id: ' + id);
    return this.httpClient.get<Number>(
      `${this.endPointPlantingArea}/${id}/count`
    );
  }
}
