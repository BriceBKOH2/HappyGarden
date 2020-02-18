import { Message } from './Message';
import { UserAccount } from './user-account';

export class Conversation {
  id: number;
  messages: Message[];
  users: UserAccount[];
}
