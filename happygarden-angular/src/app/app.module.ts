import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { SidebarModule } from 'ng-sidebar';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { NavigationModule } from './navigation/navigation.module';
import { HomeModule } from './home/home.module';
import { FormsModule } from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { StorageModule } from '@ngx-pwa/local-storage';
import { AuthenticateModule } from './authenticate/authenticate.module';
import { AuthenticateApiService } from './services/authenticateApi/authenticate-api.service';
import { AuthInterceptorService } from './authenticate/services/auth-interceptor.service';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatCheckboxModule } from '@angular/material';
import { ReactiveFormsModule } from '@angular/forms';
// import {MatDialogModule, MatDialogRef} from '@angular/material/dialog';

@NgModule({
  declarations: [AppComponent],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NavigationModule,
    HttpClientModule,
    SidebarModule.forRoot(),
    HomeModule,
    FormsModule,
    HttpClientModule,
    StorageModule.forRoot({ IDBNoWrap: true }),
    AuthenticateModule.forRoot(AuthenticateApiService),
    BrowserAnimationsModule,
    ReactiveFormsModule,
    MatCheckboxModule,
    // MatDialogModule
  ],
  exports: [MatCheckboxModule],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: AuthInterceptorService,
      multi: true
    },
    // tentative pour boite de dialogue modale (création de reminders)
    // {
    //   provide: MatDialogRef,
    //   useValue: {}
    // },
    // DialogService
  ],
  bootstrap: [AppComponent]
})
export class AppModule {}
