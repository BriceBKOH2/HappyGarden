import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { SidebarModule } from 'ng-sidebar';
import { RouterModule, Routes } from '@angular/router';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './navigation/navbar/navbar.component';
import { NavGardenComponent } from './navigation/nav-garden/nav-garden.component';
import { NavigationModule } from './navigation/navigation.module';
import { UserManagementComponent } from './admin-management/user-management/user-management.component';
import { PlantManagementComponent } from './admin-management/plant-management/plant-management.component';
import { HomeModule } from './home/home.module';
import { AdminManagementRoutingModule } from './admin-management/admin-management-routing.module';

@NgModule({
  declarations: [AppComponent, PlantManagementComponent],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NavigationModule,
    SidebarModule.forRoot(),
    HomeModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {}
