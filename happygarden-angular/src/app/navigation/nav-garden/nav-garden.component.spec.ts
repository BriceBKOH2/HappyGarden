import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NavGardenComponent } from './nav-garden.component';

describe('NavGardenComponent', () => {
  let component: NavGardenComponent;
  let fixture: ComponentFixture<NavGardenComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [NavGardenComponent]
    }).compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NavGardenComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
