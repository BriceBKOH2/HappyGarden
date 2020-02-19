import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PlantApiComponent } from './plant-api.component';

describe('PlantApiComponent', () => {
  let component: PlantApiComponent;
  let fixture: ComponentFixture<PlantApiComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PlantApiComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PlantApiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
