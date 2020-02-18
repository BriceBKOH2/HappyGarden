import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BodyGardenComponent } from './body-garden.component';

describe('BodyGardenComponent', () => {
  let component: BodyGardenComponent;
  let fixture: ComponentFixture<BodyGardenComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BodyGardenComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BodyGardenComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
