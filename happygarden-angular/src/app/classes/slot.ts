import { Reminder } from './reminder';
import { Plant } from './plant';
import { PlantingArea } from './planting-area';

export class Slot {
  id: number;
  date: Date;
  plant: Plant;
  // area_slots: PlantingArea;
  reminders: Reminder[];
}
