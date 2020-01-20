import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'happygarden-angular';

  opened: boolean;

  ngOnInit() {
    this.opened = true;
  }
}
