import { Injectable, OnDestroy } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { RequestService } from '../request/request.service';
import { PlantingArea } from 'src/app/classes/planting-area';
import { Slot } from 'src/app/classes/slot';
import { Reminder } from 'src/app/classes/reminder';
import { Observable } from 'rxjs';
import { untilDestroyed } from 'ngx-take-until-destroy';

@Injectable({
  providedIn: 'root'
})
export class ReminderServiceService implements OnDestroy {

  constructor(
    private httpClient: HttpClient,
    private request: RequestService
  ) { }

  get endPoint(): string {
    return this.request.endPoint + '/Reminder';
  }

  get endPointPlantingArea(): string {
    return this.request.endPoint + '/PlantingArea'
  }

  get endPointSlot(): string {
    return this.request.endPoint + '/Slot'
  }

  /**
   * Returns an observable of all reminders attached to the area in parameter.
   * @param area the area (Planting area or Slot) concerned
   */
  getRemindersFromArea(area: PlantingArea | Slot): Observable<Reminder[]> {
    if (area instanceof PlantingArea) {
      console.log("PlantingArea")
      return this.httpClient.get<Reminder[]>(`${this.endPoint}/area/${area.id}`, {});
    }
    if (area instanceof Slot) {
      console.log("SLot")
      return this.httpClient.get<Reminder[]>(`${this.endPoint}/slot/${area.id}`, {});
    }
    return null;
  }

  /**
   * Create a reminder associated with a slot.
   * @param reminder reminder to save in db
   * @param area Slot that will be associated to the reminder
   * @param associatedPlantingAreaId Id of the planting area where the slot is.
   */
  createReminderSlot(reminder: Reminder, area: Slot, associatedPlantingAreaId: number) {
    // Creation du reminder
    this.httpClient.post<Reminder>(`${this.endPoint}`, JSON.stringify(reminder))
      .pipe(untilDestroyed(this))
      .subscribe(
        (r) => {
          reminder = r
          area.reminders.push(r)

          // on met à jour le planting area associé au slot
          return this.httpClient.put<Slot>(`${this.endPointSlot}/plantingArea/${associatedPlantingAreaId}`, area).subscribe();
        },
        (err) => (console.log(err))
      )
  }

  createReminderPlantingArea(reminder: Reminder, area: PlantingArea) {
    this.httpClient.post<Reminder>(`${this.endPoint}`, JSON.stringify(reminder))
      .pipe(untilDestroyed(this))
      .subscribe(
        (r) => {
          area.reminders.push(r)
          return this.httpClient.put<PlantingArea>(`${this.endPointPlantingArea}`, area);
        },
        (err) => (console.log(err))
      )
  }

  ngOnDestroy(): void {
  }
}
