import { Reminder } from './reminder';
import { Plant } from './plant';

export class Slot {
  id: string;
  date: Date;
  plant: Plant;
  reminders: Reminder[];
}
