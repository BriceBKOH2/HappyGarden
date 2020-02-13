import { ModuleWithProviders, NgModule, Type } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AuthApiToken } from './services/authenticate.service';
import { AuthenticateApi } from './interfaces/authenticate-api';

@NgModule({
  declarations: [],
  imports: [CommonModule]
})
export class AuthenticateModule {
  static forRoot(Service: Type<AuthenticateApi>): ModuleWithProviders {
    return {
      ngModule: AuthenticateModule,
      providers: [{ provide: AuthApiToken, useClass: Service }]
    };
  }
}
