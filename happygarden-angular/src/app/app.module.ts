import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { SidebarModule } from 'ng-sidebar';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './navigation/navbar/navbar.component';
import { NavigationModule } from './navigation/navigation.module';
import { HomeModule } from './home/home.module';
import { HttpClientModule } from '@angular/common/http';
import { StorageModule } from '@ngx-pwa/local-storage';

@NgModule({
  declarations: [AppComponent],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NavigationModule,
    SidebarModule.forRoot(),
    HomeModule,
    HttpClientModule,
    StorageModule.forRoot({ IDBNoWrap: true })
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {}
