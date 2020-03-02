import { Component, OnInit } from '@angular/core';
import { Reminder } from 'src/app/classes/reminder';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ReminderServiceService } from 'src/app/services/reminders/reminder-service.service';

@Component({
  selector: 'app-reminder-edit',
  templateUrl: './reminder-edit.component.html',
  styleUrls: ['./reminder-edit.component.scss']
})
export class ReminderEditComponent implements OnInit {

  reminderCreationForm: FormGroup;
  reminder: Reminder;
  // id: number;
  // name: string;
  // content: string;
  // activationDate: Date;

  constructor(
    private formBuilder: FormBuilder,
    private reminderService: ReminderServiceService
  ) { }

  ngOnInit() {

    this.reminderCreationForm = this.formBuilder.group({
      reminderName: ['', Validators.required],
      reminderContent: [''],
      reminderActivationDate: ['', Validators.required]
    });
  }

  onSubmit() {
    if (this.reminderCreationForm.invalid) {
      return;
    }

    this.reminder = {
      name: this.reminderCreationForm.controls.reminderName.value,
      content: this.reminderCreationForm.controls.reminderContent.value,
      activationDate: this.reminderCreationForm.controls.reminderActivationDate.value
    }

    console.log(this.reminder)
    this.reminderService.createReminder(this.reminder, null)
    // TODO : associer le reminder à la bonne planting area. = > this.myGardens.currentSlot
  }

}
