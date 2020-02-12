import { TestBed } from '@angular/core/testing';

import { AuthenticateApiService } from './authenticate-api.service';

describe('AuthenticateApiService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: AuthenticateApiService = TestBed.get(AuthenticateApiService);
    expect(service).toBeTruthy();
  });
});
