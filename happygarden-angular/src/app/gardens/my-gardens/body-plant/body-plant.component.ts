import { Component, OnInit } from '@angular/core';
import { MyGardensComponent } from '../my-gardens.component';
import { FileService } from 'src/app/services/file/file.service';
import { ReminderServiceService } from 'src/app/services/reminders/reminder-service.service';
import { Reminder } from 'src/app/classes/reminder';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-body-plant',
  templateUrl: './body-plant.component.html',
  styleUrls: ['./body-plant.component.scss']
})
export class BodyPlantComponent implements OnInit {
  constructor(
    public myGardens: MyGardensComponent,
    private fileService: FileService,
    private reminderService: ReminderServiceService
  ) {}

  reminders$: Observable<Reminder[]>;

  // flag to check for displaying reminder creation.
  reminderCreate: Boolean;

  ngOnInit() {
    this.reminderCreate = false
    this.reminders$ = this.reminderService.getRemindersFromArea(this.myGardens.currentSlot);
  }

  toggleReminderForm() {
    this.reminderCreate = !this.reminderCreate;
  }
}
