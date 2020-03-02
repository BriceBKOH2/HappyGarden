import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreatePlantingAreaComponent } from './create-planting-area.component';

describe('CreatePlantingAreaComponent', () => {
  let component: CreatePlantingAreaComponent;
  let fixture: ComponentFixture<CreatePlantingAreaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreatePlantingAreaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreatePlantingAreaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
