import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ProfileComponent } from './profile/profile.component';
import { AccountModule } from '../account/account.module';

@NgModule({
  declarations: [ProfileComponent],
  imports: [CommonModule, AccountModule]
})
export class ProfileModule {}
