import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PlantManagementComponent } from './plant-management.component';

describe('PlantManagementComponent', () => {
  let component: PlantManagementComponent;
  let fixture: ComponentFixture<PlantManagementComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PlantManagementComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PlantManagementComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
