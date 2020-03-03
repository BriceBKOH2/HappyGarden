import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { RequestService } from '../request/request.service';
import { PlantingArea } from 'src/app/classes/planting-area';
import { Slot } from 'src/app/classes/slot';
import { Reminder } from 'src/app/classes/reminder';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ReminderServiceService {

  constructor(
    private httpClient: HttpClient,
    private request: RequestService
  ) { }

  get endPoint(): string {
    return this.request.endPoint + '/Reminder';
  }

  /**
   * Returns an observable of all reminders attached to the area in parameter.
   * @param area the area (Planting area or Slot) concerned
   */
  getRemindersFromArea(area: PlantingArea | Slot): Observable<Reminder[]> {
    if (area instanceof PlantingArea) {
      return this.httpClient.get<Reminder[]>(`${this.endPoint}/area/${area.id}`, {});
    }
    if (area instanceof Slot) {
      return this.httpClient.get<Reminder[]>(`${this.endPoint}/slot/${area.id}`, {});
    }
    return null;
  }
}
