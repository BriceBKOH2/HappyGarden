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
import { AuthenticateApiService } from './service/authenticateApi/authenticate-api.service';
import { AuthInterceptorService } from './authenticate/service/auth-interceptor.service';

@NgModule({
  declarations: [AppComponent],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NavigationModule,
    SidebarModule.forRoot(),
    HomeModule,
    FormsModule,
    HttpClientModule,
    StorageModule.forRoot({ IDBNoWrap: true }),
    AuthenticateModule.forRoot(AuthenticateApiService)
  ],
  bootstrap: [AppComponent],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: AuthInterceptorService,
      multi: true
    }
  ]
})
export class AppModule {}
