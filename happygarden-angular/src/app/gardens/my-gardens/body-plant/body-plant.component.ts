import { Component, OnInit, Inject } from '@angular/core';
import { MyGardensComponent } from '../my-gardens.component';
import { FileService } from 'src/app/services/file/file.service';
import { ReminderServiceService } from 'src/app/services/reminders/reminder-service.service';
import { Reminder } from 'src/app/classes/reminder';
import { Observable } from 'rxjs';
import { MatDialog, MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { ReminderEditComponent } from 'src/app/reminders/reminder-edit/reminder-edit.component';

@Component({
  selector: 'app-body-plant',
  templateUrl: './body-plant.component.html',
  styleUrls: ['./body-plant.component.scss']
})
export class BodyPlantComponent implements OnInit {
  constructor(
    public myGardens: MyGardensComponent,
    private fileService: FileService,
    private reminderService: ReminderServiceService,
    public dialog: MatDialog
  ) {
  }

  reminders$: Observable<Reminder[]>;
  reminders: Reminder[]

  // flag to check for displaying reminder form creation.
  reminderCreate: Boolean;

  ngOnInit() {
    this.reminderCreate = false
    console.log(this.myGardens.currentSlot)
    this.reminders$ = this.reminderService.getRemindersFromArea(this.myGardens.currentSlot);
    // this.reminderService.getRemindersFromArea(this.myGardens.currentSlot)
    //   .subscribe(r => {
    //     this.reminders = r
    //     console.log(r)
    //   });

  }

  toggleReminderForm() {
    this.reminderCreate = !this.reminderCreate;
    // const dialogRef = this.dialog.open(ReminderEditComponent, {
    //   width: '450px',
    //   data: {} // {name: "test name", animal: "test animal"}
    // });

    // dialogRef.afterClosed().subscribe(rr => {
    //   console.log('The dialog was closed');
    // });
  }
}
