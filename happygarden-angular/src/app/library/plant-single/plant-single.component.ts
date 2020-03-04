import { Component, OnInit } from '@angular/core';
import { LibraryService } from '../service/library.service';
import { Plant } from 'src/app/classes/plant';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { untilDestroyed } from 'ngx-take-until-destroy';

@Component({
  selector: 'app-plant-single',
  templateUrl: './plant-single.component.html',
  styleUrls: ['./plant-single.component.scss']
})
export class PlantSingleComponent implements OnInit {
  constructor(
    private libraryService: LibraryService,
    private activatedRoute: ActivatedRoute
  ) {}

  plant$: Observable<Plant>;

  // plant: Plant;

  ngOnInit() {
    this.activatedRoute.params.pipe(untilDestroyed(this)).subscribe(r => {
      this.plant$ = this.libraryService.findPlant(r.id);
    });

    // this.activatedRoute.params
    //   .pipe(
    //     switchMap(params => {
    //       return this.libraryService.findPlant(params.id);
    //     })
    //   )
    //   .subscribe(response => {
    //     this.plant = response;
    //   });
  }

  ngOnDestroy() {}
}
