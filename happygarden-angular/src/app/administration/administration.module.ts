import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AdminMenuComponent } from './admin-menu/admin-menu.component';
import { AdministrationRoutingModule } from './administration-routing.module';



@NgModule({
  declarations: [AdminMenuComponent],
  imports: [CommonModule, AdministrationRoutingModule]
})
export class AdministrationModule { }
