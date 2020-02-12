import { Reminder } from './reminder';
import { Slot } from './slot';

export class PlantingArea {
  id: number;
  name: string;
  reminders: Reminder[];
  slots: Slot[];
  length: number;
  width: number;
}
