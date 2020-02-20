import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { RequestService } from 'src/app/services/request/request.service';
import { Garden } from 'src/app/classes/garden';
import { Observable } from 'rxjs';

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

  postGarden(garden: Garden): Observable<Garden> {
    return this.httpClient.post<Garden>(`${this.endPointGarden}`, garden);
  }
}
