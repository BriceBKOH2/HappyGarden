import { Garden } from './garden';
import { Plant } from './plant';
import { Conversation } from './conversation';
import { UserRole } from './user-role';

export class UserAccount {
  id: number;
  firstname: string;
  lastname: string;
  nickname: string;
  password: string;
  userRole: UserRole;
  profileImg: string;
  conversations: Conversation[];
  friends: UserAccount[];
  usedPlants: Plant[];
  favoritePlants: Plant[];
  gardens: Garden[];
}
