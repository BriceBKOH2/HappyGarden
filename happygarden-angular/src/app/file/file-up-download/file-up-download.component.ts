import { Component, OnInit } from '@angular/core';

// import * as fileSaver from 'file-saver';
import { HttpResponse, HttpEventType } from '@angular/common/http';
import { FileService } from 'src/app/services/file/file.service';

@Component({
  selector: 'app-file-up-download',
  templateUrl: './file-up-download.component.html',
  styleUrls: ['./file-up-download.component.scss']
})
export class FileUpDownloadComponent implements OnInit {
  title = 'File-Upload-Save';
  selectedFiles: FileList;
  currentFileUpload: File;
  progress: { percentage: number } = { percentage: 0 };
  selectedFile = null;
  changeImage = false;

  constructor(private fileService: FileService) {}

  ngOnInit() {}

  downloadFile(file: string) {
    // const link = document.createElement('a');
    // link.setAttribute('target', '_blank');
    // link.setAttribute('href', '_File_Saved_Path');
    // link.setAttribute('download', 'file_name.pdf');
    // document.body.appendChild(link);
    // link.click();
    // link.remove();
    this.fileService.downloadFile(file);
  }

  change($event) {
    this.changeImage = true;
  }

  changedImage(event) {
    this.selectedFile = event.target.files[0];
  }

  upload() {
    this.progress.percentage = 0;
    this.currentFileUpload = this.selectedFiles.item(0);
    this.fileService
      .pushFileToStorage(this.currentFileUpload)
      .subscribe(event => {
        if (event.type === HttpEventType.UploadProgress) {
          this.progress.percentage = Math.round(
            (100 * event.loaded) / event.total
          );
        } else if (event instanceof HttpResponse) {
          alert('File Successfully Uploaded');
        }
        this.selectedFiles = undefined;
      });
  }

  selectFile(event) {
    this.selectedFiles = event.target.files;
  }

  // download() {
  //   this.fileService.downloadFile().subscribe(response => {
  //     let blob: any = new Blob([response.blob()], {
  //       type: 'text/json; charset=utf-8'
  //     });
  //     const url = window.URL.createObjectURL(blob);
  //     window.open(url);
  //     window.location.href = response.url;
  //     fileSaver.saveAs(blob, 'employees.json');
  //   }),
  //     error => console.log('Error downloading the file'),
  //     () => console.info('File downloaded successfully');
  // }
}
