import { fakeAsync, TestBed, tick } from '@angular/core/testing';

import { LibraryService } from './library.service';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { Subscription } from 'rxjs';

describe('LibraryService', () => {
  let httpTestingController: HttpTestingController;
  let service: LibraryService;
  let allSubscription: Subscription;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule]
    });
    service = TestBed.get(LibraryService);
    httpTestingController = TestBed.get(HttpTestingController);
    allSubscription = new Subscription();
  });

  afterEach(() => {
    allSubscription.unsubscribe();
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  describe('findAllPlants', () => {

    beforeEach(() => {
      spyOnProperty(service, 'endPointPlant', 'get').and.returnValue('endpoint');
    });

    it('should return list', fakeAsync(() => {
      let value;
      const res = {};
      allSubscription.add(service.findAllPlants().subscribe((v) => {
        value = v;
      }));
      const testingRequest = httpTestingController.expectOne('endpoint');
      testingRequest.flush(res);
      tick();
      expect(value).toEqual(res);
    }));

  });
  describe('findPlant', () => {

    beforeEach(() => {
      spyOnProperty(service, 'endPointPlant', 'get').and.returnValue('endpoint');
    });

    it('should return item', fakeAsync(() => {
      let value;
      const res = {};
      allSubscription.add(service.findPlant(1).subscribe((v) => {
        value = v;
      }));
      const testingRequest = httpTestingController.expectOne('endpoint/1');
      expect(testingRequest.request.method).toEqual('GET');
      testingRequest.flush(res);
      tick();
      expect(value).toEqual(res);
    }));

  });

});
