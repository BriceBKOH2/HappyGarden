import { Injectable } from '@angular/core';
import {
  HttpResponse,
  HttpClient,
  HttpEvent,
  HttpRequest
} from '@angular/common/http';
import { HttpModule, Http, ResponseContentType } from '@angular/http';
import { Observable } from 'rxjs';
import { RequestService } from '../request/request.service';

@Injectable({
  providedIn: 'root'
})
export class FileService {
  constructor(
    private http: Http,
    private https: HttpClient,
    private request: RequestService
  ) {}

  get endPointDownload(): string {
    return this.request.endPoint + '/downloadFile';
  }

  get endPointUpload(): string {
    return this.request.endPoint + '/uploadFile';
  }

  downloadFile(file: string): Observable<any> {
    return this.http.get(`${this.endPointDownload}/${file}`, {
      responseType: ResponseContentType.Blob
    });
  }

  pushFileToStorage(file: File): Observable<HttpEvent<{}>> {
    const data: FormData = new FormData();
    data.append('file', file);
    const newRequest = new HttpRequest('POST', `${this.endPointUpload}`, data, {
      reportProgress: true,
      responseType: 'text'
    });
    return this.https.request(newRequest);
  }
}
