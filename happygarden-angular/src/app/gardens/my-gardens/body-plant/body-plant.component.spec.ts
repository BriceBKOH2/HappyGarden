import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BodyPlantComponent } from './body-plant.component';

describe('BodyPlantComponent', () => {
  let component: BodyPlantComponent;
  let fixture: ComponentFixture<BodyPlantComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BodyPlantComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BodyPlantComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
