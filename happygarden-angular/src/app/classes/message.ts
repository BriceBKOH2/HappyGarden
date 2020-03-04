import { Content } from '@angular/compiler/src/render3/r3_ast';
import { UserAccount } from './user-account';
import { Conversation } from './conversation';

export class Message {
  id: number;
  content: Content;
  author: string;
  conversation: Conversation;
}
