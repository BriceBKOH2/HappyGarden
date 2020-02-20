import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { RequestService } from '../request/request.service';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PlantAPITrefleIoService {
  tokenApi = 'ajZaYWYwa1ZwMWUyT0NVYkVUd3E3Zz09';
  headerApi = new HttpHeaders()
    .append('Access-Control-Allow-Origin', '*')
    .append('Authorization', `Bearer ${this.tokenApi}`);

  constructor(private httpClient: HttpClient) {}

  get EndPoint() {
    return 'https://trefle.io/api';
  }

  get EndPointKingdoms() {
    return this.EndPoint + '/kingdoms';
  }

  get EndPointSubkingdoms() {
    return this.EndPoint + '/subkingdoms';
  }

  get EndPointDivisions() {
    return this.EndPoint + '/divisions';
  }

  get EndPointFamilies() {
    return this.EndPoint + '/families';
  }

  get EndPointGenuses() {
    return this.EndPoint + 'genuses';
  }

  get EndPointPlants() {
    return this.EndPoint + 'plants';
  }

  /*
  Plant hierarchie in API :

  Kingdom
  -> Subkingdom
    -> Division
      -> Division class
        -> Division order
          -> Family
            -> Genus
              -> Plant
  */

  getKingdom(id: number): Observable<any> {
    return this.httpClient.get(
      this.EndPoint + this.EndPointKingdoms + `/${id}`,
      { headers: this.headerApi }
    );
  }

  getAllKingdom(): Observable<any> {
    return this.httpClient.get(this.EndPoint + this.EndPointKingdoms, {
      headers: this.headerApi
    });
  }
}
