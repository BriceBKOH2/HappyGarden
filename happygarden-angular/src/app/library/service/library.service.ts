import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Plant } from 'src/app/classes/plant';
import { PlantUser } from 'src/app/classes/plant-user.model'
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LibraryService {
  constructor(private httpClient: HttpClient) {}

  get endPointPlant() {
    return 'http://localhost:8082/happygarden/api/Plant';
  }

  get endPointPlantUser() {
    return 'http://localhost:8082/happygarden/api/PlantUser/searchPlantUser'
  }

  findAllPlants(): Observable<Plant[]> {
    return this.httpClient.get<Plant[]>(this.endPointPlant);
  }

  findPlant(id: number) {
    return this.httpClient.get<Plant>(`${this.endPointPlant}/${id}`);
  }

  searchByCommonNameOrScientificName(name: string): Observable<Plant[]> {
    return this.httpClient.get<Plant[]>(`${this.endPointPlant}/search`, {
      params: new HttpParams().set('name', name)
    });
  }

  findByCreator(name: string): Observable<PlantUser[]> {
    return this.httpClient.get<PlantUser[]>(this.endPointPlantUser, {
      params: new HttpParams().set('name', name)
    });
  }

}
