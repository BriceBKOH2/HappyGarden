import { PlantingArea } from './planting-area';
import { Comment } from './comment';

export class Garden {
  id: string;
  name: string;
  plantingAreas: PlantingArea[];
  comments: Comment[];
}
