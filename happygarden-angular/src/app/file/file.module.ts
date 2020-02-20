import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FileUpDownloadComponent } from './file-up-download/file-up-download.component';

@NgModule({
  declarations: [FileUpDownloadComponent],
  imports: [CommonModule],
  exports: [FileUpDownloadComponent]
})
export class FileModule {}
