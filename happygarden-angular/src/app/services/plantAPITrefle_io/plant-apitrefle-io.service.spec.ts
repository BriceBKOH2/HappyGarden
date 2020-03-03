import { TestBed } from '@angular/core/testing';

import { PlantAPITrefleIoService } from './plant-apitrefle-io.service';

describe('PlantAPITrefleIoService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: PlantAPITrefleIoService = TestBed.get(PlantAPITrefleIoService);
    expect(service).toBeTruthy();
  });
});
