import { Garden } from './garden';
import { Plant } from './plant';
import { Conversation } from './conversation';

export class UserAccount {
  id: string;
  firstName: string;
  lastName: string;
  pseudonyme: string;
  password: string;
  userRole: UserAccount;
  conversations: Conversation[];
  friends: UserAccount[];
  usedPlants: Plant[];
  favoritePlants: Plant[];
  gardens: Garden[];
}
