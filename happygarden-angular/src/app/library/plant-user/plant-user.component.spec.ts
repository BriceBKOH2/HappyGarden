import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PlantUserComponent } from './plant-user.component';

describe('PlantUserComponent', () => {
  let component: PlantUserComponent;
  let fixture: ComponentFixture<PlantUserComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PlantUserComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PlantUserComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
