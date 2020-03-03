import { Component, OnInit } from '@angular/core';
import { Reminder } from 'src/app/classes/reminder';

@Component({
  selector: 'app-reminder-edit',
  templateUrl: './reminder-edit.component.html',
  styleUrls: ['./reminder-edit.component.scss']
})
export class ReminderEditComponent implements OnInit {

  reminder: Reminder;

  constructor() { }

  ngOnInit() {
  }

}
