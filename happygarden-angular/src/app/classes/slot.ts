import { Reminder } from './reminder';
import { Plant } from './plant';

export class Slot {
  id: number;
  date: Date;
  plant: Plant;
  reminders: Reminder[];
}
