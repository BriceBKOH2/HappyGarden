import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FileUpDownloadComponent } from './file-up-download/file-up-download.component';
import { HttpModule } from '@angular/http';

@NgModule({
  declarations: [FileUpDownloadComponent],
  imports: [CommonModule, HttpModule],
  exports: [FileUpDownloadComponent]
})
export class FileModule {}
