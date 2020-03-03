import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SidebarAccountComponent } from './sidebar-account.component';

describe('SidebarAccountComponent', () => {
  let component: SidebarAccountComponent;
  let fixture: ComponentFixture<SidebarAccountComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SidebarAccountComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SidebarAccountComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
