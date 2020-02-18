import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BodyPlantingAreaComponent } from './body-planting-area.component';

describe('BodyPlantingAreaComponent', () => {
  let component: BodyPlantingAreaComponent;
  let fixture: ComponentFixture<BodyPlantingAreaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BodyPlantingAreaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BodyPlantingAreaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
