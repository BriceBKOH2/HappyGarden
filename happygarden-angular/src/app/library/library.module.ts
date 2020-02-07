import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { LibraryRoutingModule } from './library-routing.module';
import { LibraryListComponent } from './library-list/library-list.component';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [LibraryListComponent],
  imports: [CommonModule, LibraryRoutingModule, FormsModule]
})
export class LibraryModule {}
