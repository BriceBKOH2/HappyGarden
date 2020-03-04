import { Reminder } from './reminder';
import { Plant } from './plant';
import { PlantUser } from './plant-user.model';
import { PlantingArea } from './planting-area';

export class Slot {
  id: number;
  date: Date;
  plant: Plant | PlantUser;
  reminders: Reminder[];
  plantingArea: PlantingArea;

  constructor(date?: Date, plant?: Plant | PlantUser) {
    this.date = date;
    this.plant = plant;
  }
}
