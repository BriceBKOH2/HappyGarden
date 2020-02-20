import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateGardenComponent } from './create-garden.component';

describe('CreateGardenComponent', () => {
  let component: CreateGardenComponent;
  let fixture: ComponentFixture<CreateGardenComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreateGardenComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateGardenComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
