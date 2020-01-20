import { PlantingArea } from './planting-area';
import { Reminder } from './reminder';
import { Plant } from './plant';

export class Slot {
  date: Date;
  plant: Plant;
  reminders: Reminder[];
}
