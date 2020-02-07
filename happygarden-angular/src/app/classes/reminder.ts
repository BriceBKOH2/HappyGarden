import { Content } from '@angular/compiler/src/render3/r3_ast';

export class Reminder {
  id: string;
  name: string;
  content: Content;
  activationDate: Date;
}
