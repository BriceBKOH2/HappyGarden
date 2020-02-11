import { TestBed } from '@angular/core/testing';

import { AuthapiService } from './authapi.service';

describe('AuthapiService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: AuthapiService = TestBed.get(AuthapiService);
    expect(service).toBeTruthy();
  });
});
