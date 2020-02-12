import { Content } from '@angular/compiler/src/render3/r3_ast';

export class Reminder {
  id: number;
  name: string;
  content: Content;
  activationDate: Date;
}
