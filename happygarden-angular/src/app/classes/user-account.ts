import { Garden } from './garden';
import { Plant } from './plant';
import { Conversation } from './conversation';

export class UserAccount {
  id: number;
  firstname: string;
  lastname: string;
  nickname: string;
  password: string;
  userRole: UserAccount;
  conversations: Conversation[];
  friends: UserAccount[];
  usedPlants: Plant[];
  favoritePlants: Plant[];
  gardens: Garden[];
}
