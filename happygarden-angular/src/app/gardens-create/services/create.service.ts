import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { RequestService } from 'src/app/services/request/request.service';
import { Garden } from 'src/app/classes/garden';
import { Observable } from 'rxjs';
import { PlantingArea } from 'src/app/classes/planting-area';

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

  postGarden(garden: Garden): Observable<Garden> {
    console.log('postGarden service');
    return this.httpClient.post<Garden>(`${this.endPointGarden}`, garden);
  }

  getGarden(id: number): Observable<Garden> {
    console.log('getGarden id: ' + id);
    return this.httpClient.get<Garden>(`${this.endPointGarden}/${id}`);
  }

  postPlantingArea(plantingArea: PlantingArea): Observable<PlantingArea> {
    console.log('postPlantingArea service');
    return this.httpClient.post<PlantingArea>(
      `${this.endPointPlantingArea}`,
      plantingArea
    );
  }
}
