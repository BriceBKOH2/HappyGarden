
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NavbarComponent } from './navbar/navbar.component';
import { NavGardenComponent } from './nav-garden/nav-garden.component';
import { SidebarModule } from 'ng-sidebar';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { RouterModule } from '@angular/router';

@NgModule({
  declarations: [NavbarComponent, NavGardenComponent],
  exports: [NavbarComponent, NavGardenComponent],
  imports: [CommonModule, SidebarModule.forRoot(), NgbModule, RouterModule]
})
export class NavigationModule {}
