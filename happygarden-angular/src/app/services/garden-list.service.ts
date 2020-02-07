import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { UserAccount } from '../classes/user-account';
import { Garden } from '../classes/garden';

@Injectable({
  providedIn: 'root'
})
export class GardenListService {
  private baseUrl = 'http://localhost:8082/happygarden/api/UserAccount';

  constructor(private httpClient: HttpClient) {}

  get httpOptions(): { headers: HttpHeaders } {
    const headers = new HttpHeaders().set('Content-Type', 'application/json');
    return {
      headers
    };
  }

  getGardens(id: number): Observable<Garden[]> {
    return this.httpClient.get<Garden[]>(
      `${this.baseUrl}/${id}/gardens`,
      this.httpOptions
    );
  }
}
