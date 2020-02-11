import { async, ComponentFixture, fakeAsync, TestBed, tick } from '@angular/core/testing';

import { LibraryListComponent } from './library-list.component';
import { LibraryService } from '../service/library.service';
import { Subject } from 'rxjs';
import { RouterTestingModule } from '@angular/router/testing';

describe('LibraryListComponent', () => {
  let component: LibraryListComponent;
  let fixture: ComponentFixture<LibraryListComponent>;
  let libraryServiceMock;
  let libraryService: LibraryService;

  beforeEach(async(() => {
    libraryServiceMock = jasmine.createSpyObj(['findAllPlants']);
    TestBed.configureTestingModule({
      declarations: [LibraryListComponent],
      imports: [
        RouterTestingModule,
      ],
      providers: [
        {provide: LibraryService, useValue: libraryServiceMock}
      ]
    })
      .compileComponents();
    libraryService = TestBed.get(LibraryService);

  }));
  let subjectFind;
  beforeEach(() => {
    subjectFind = new Subject();
    libraryServiceMock.findAllPlants.and.returnValue(subjectFind);
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(LibraryListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should use findAllPlants', () => {
    expect(libraryService.findAllPlants).toHaveBeenCalled();
  });

  it('should save return findAllPlants in plants', fakeAsync(() => {
    const plants = [];
    subjectFind.next(plants);
    tick();
    expect(component.plants).toEqual(plants);
  }));
});
