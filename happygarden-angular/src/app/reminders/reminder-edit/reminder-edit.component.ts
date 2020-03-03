import { Component, OnInit, Input } from '@angular/core';
import { Reminder } from 'src/app/classes/reminder';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ReminderServiceService } from 'src/app/services/reminders/reminder-service.service';
import { PlantingArea } from 'src/app/classes/planting-area';
import { Slot } from 'src/app/classes/slot';

@Component({
  selector: 'app-reminder-edit',
  templateUrl: './reminder-edit.component.html',
  styleUrls: ['./reminder-edit.component.scss']
})
export class ReminderEditComponent implements OnInit {

  @Input()
  selectedSlot: Slot

  @Input()
  selectedPlantingArea: PlantingArea

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

    this.reminderService.createReminderSlot(this.reminder, this.selectedSlot, this.selectedPlantingArea.id)
  }

}
