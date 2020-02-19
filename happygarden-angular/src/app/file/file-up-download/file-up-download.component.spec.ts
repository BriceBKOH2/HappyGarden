import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FileUpDownloadComponent } from './file-up-download.component';

describe('FileUpDownloadComponent', () => {
  let component: FileUpDownloadComponent;
  let fixture: ComponentFixture<FileUpDownloadComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FileUpDownloadComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FileUpDownloadComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
