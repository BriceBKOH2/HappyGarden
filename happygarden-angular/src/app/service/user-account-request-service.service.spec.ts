import { TestBed } from '@angular/core/testing';

import { UserAccountRequestServiceService } from './user-account-request-service.service';

describe('UserAccountRequestServiceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: UserAccountRequestServiceService = TestBed.get(UserAccountRequestServiceService);
    expect(service).toBeTruthy();
  });
});
