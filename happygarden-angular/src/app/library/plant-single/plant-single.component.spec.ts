import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PlantSingleComponent } from './plant-single.component';

describe('PlantSingleComponent', () => {
  let component: PlantSingleComponent;
  let fixture: ComponentFixture<PlantSingleComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PlantSingleComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PlantSingleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
