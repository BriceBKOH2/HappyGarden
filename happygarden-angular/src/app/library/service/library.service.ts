import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Plant } from 'src/app/classes/plant';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LibraryService {
  constructor(private httpClient: HttpClient) {}

  get endPointPlant() {
    return 'http://localhost:8082/happygarden/api/Plant';
  }

  findAllPlants(): Observable<Plant[]> {
    return this.httpClient.get<Plant[]>(this.endPointPlant);
  }

  findPlant(id: number) {
    return this.httpClient.get<Plant>(`${this.endPointPlant}/${id}`);
  }
}
