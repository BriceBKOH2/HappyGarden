import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HomepageComponent } from './homepage/homepage.component';
import { HomeRoutingModule } from './home-routing.module';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [HomepageComponent],
  imports: [CommonModule, HomeRoutingModule, FormsModule]
})
export class HomeModule {}
