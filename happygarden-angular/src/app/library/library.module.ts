import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { LibraryRoutingModule } from './library-routing.module';
import { LibraryListComponent } from './library-list/library-list.component';

@NgModule({
  declarations: [LibraryListComponent],
  imports: [CommonModule, LibraryRoutingModule]
})
export class LibraryModule {}
