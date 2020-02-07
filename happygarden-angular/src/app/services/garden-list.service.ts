import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class GardenListService {
  private baseUrl = 'http://localhost:8082/api/UserAccount';

  constructor(private httpClient: HttpClient) {}
}
