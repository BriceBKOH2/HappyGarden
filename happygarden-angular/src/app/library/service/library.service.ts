import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Plant } from 'src/app/classes/plant';
import { PlantUser } from 'src/app/classes/plant-user.model'
import { Observable, BehaviorSubject } from 'rxjs';
import { RequestService } from 'src/app/services/request/request.service';
import { AuthenticateService } from 'src/app/authenticate/services/authenticate.service';
import { GrowthRate } from 'src/app/enums/growth-rate.enum';

@Injectable({
  providedIn: 'root'
})
export class LibraryService {
  constructor(private httpClient: HttpClient,
     private request: RequestService,
    private authServ: AuthenticateService) {}

  get endPointPlant() {
    return this.request.endPoint+'/Plant';
  }

  get endPointPlantUser() {
    return this.request.endPoint+'/PlantUser'
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
    return this.httpClient.get<PlantUser[]>(`${this.endPointPlantUser}/searchPlantUser`, {
      params: new HttpParams().set('name', name)
    });
  }

  createPlantUser(
      newPlantUser: PlantUser): Observable<PlantUser> {
        console.log(newPlantUser)
      return this.httpClient.post<PlantUser>(this.endPointPlantUser, JSON.stringify(newPlantUser));
  }

}
