import { Garden } from './garden';
import { Plant } from './plant';
import { Conversation } from './conversation';
import { UserRole } from './user-role';

export class UserAccount {
  id?: number;
  firstname: string;
  lastname: string;
  nickname: string;
  password: string;
  userRole: UserRole;
  conversations?: Conversation[];
  friends?: UserAccount[];
  usedPlants?: Plant[];
  favoritePlants?: Plant[];
  user_gardens?: Garden[];
  profileImg?: string;
}
