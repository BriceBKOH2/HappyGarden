import { Injectable } from '@angular/core';
import { UserAccount } from '../classes/user-account';

@Injectable()
export class UserAccountRequestServiceService {
  userAccount = new UserAccount();

  constructor() {
    this.userAccount.id = 1;
  }
}
