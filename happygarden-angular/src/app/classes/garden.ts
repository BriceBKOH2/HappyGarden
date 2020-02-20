import { PlantingArea } from './planting-area';
import { Comment } from './comment';
import { UserAccount } from './user-account';

export class Garden {
  id: number;
  name: string;
  plantingAreas: PlantingArea[];
  comments: Comment[];
  user: UserAccount;

  constructor(name: string, plantingAreas?: PlantingArea[]) {
    this.name = name;
    this.plantingAreas = plantingAreas;
  }
}
