import { TestBed } from '@angular/core/testing';

import { UserAccountRequestService } from './user-account-request.service';

describe('UserAccountRequestService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: UserAccountRequestService = TestBed.get(
      UserAccountRequestService
    );
    expect(service).toBeTruthy();
  });
});
