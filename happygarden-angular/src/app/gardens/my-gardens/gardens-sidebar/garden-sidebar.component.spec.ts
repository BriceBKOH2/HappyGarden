import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GardenSidebarComponent } from './garden-sidebar.component';

describe('GardenSidebarComponent', () => {
  let component: GardenSidebarComponent;
  let fixture: ComponentFixture<GardenSidebarComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GardenSidebarComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GardenSidebarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
