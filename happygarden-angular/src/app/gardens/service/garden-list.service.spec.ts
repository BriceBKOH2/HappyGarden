import { TestBed } from '@angular/core/testing';

import { GardenListService } from './garden-list.service';

describe('GardenListService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: GardenListService = TestBed.get(GardenListService);
    expect(service).toBeTruthy();
  });
});
