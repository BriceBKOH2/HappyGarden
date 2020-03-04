import { TestBed } from '@angular/core/testing';

import { ReminderServiceService } from './reminder-service.service';

describe('ReminderServiceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ReminderServiceService = TestBed.get(ReminderServiceService);
    expect(service).toBeTruthy();
  });
});
