import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HomepageComponent } from './homepage/homepage.component';
import { HomeRoutingModule } from './home-routing.module';

@NgModule({
  declarations: [HomepageComponent],
  imports: [CommonModule, HomeRoutingModule]
})
export class HomeModule {}
