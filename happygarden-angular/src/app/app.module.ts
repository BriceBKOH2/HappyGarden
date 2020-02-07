import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { SidebarModule } from 'ng-sidebar';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavigationModule } from './navigation/navigation.module';
import { HomeModule } from './home/home.module';
import { FormsModule } from '@angular/forms';
import { UserAccountRequestServiceService } from './service/user-account-request-service.service';

@NgModule({
  declarations: [AppComponent],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NavigationModule,
    SidebarModule.forRoot(),
    HomeModule,
    FormsModule
  ],
  providers: [UserAccountRequestServiceService],
  bootstrap: [AppComponent]
})
export class AppModule {}
