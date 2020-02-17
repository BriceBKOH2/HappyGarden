import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { UserAccount } from 'src/app/classes/user-account';
import { Garden } from 'src/app/classes/garden';
import { RequestService } from 'src/app/services/request/request.service';

@Injectable({
  providedIn: 'root'
})
export class GardenListService {
  private baseUrl = this.request.endPoint + '/UserAccount';

  constructor(
    private httpClient: HttpClient,
    private request: RequestService
  ) {}

  // get httpOptions(): { headers: HttpHeaders } {
  //   const headers = new HttpHeaders().set('Content-Type', 'application/json');
  //   return {
  //     headers
  //   };
  // }

  getGardens(id: number): Observable<Garden[]> {
    return this.httpClient.get<Garden[]>(`${this.baseUrl}/${id}/gardens`);
  }
}
