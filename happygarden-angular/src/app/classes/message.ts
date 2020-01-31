import { Content } from '@angular/compiler/src/render3/r3_ast';
import { UserAccount } from './user-account';

export class Message {
  content: Content;
  author: UserAccount;
}
