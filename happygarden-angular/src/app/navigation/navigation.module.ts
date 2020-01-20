import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NavbarComponent } from './navbar/navbar.component';
import { NavGardenComponent } from './nav-garden/nav-garden.component';
import { SidebarModule } from 'ng-sidebar';

@NgModule({
  declarations: [NavbarComponent, NavGardenComponent],
  exports: [NavbarComponent, NavGardenComponent],
  imports: [CommonModule, SidebarModule.forRoot()]
})
export class NavigationModule {}
