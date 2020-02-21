import { Component, OnInit } from '@angular/core';
import { LibraryService } from '../service/library.service';
import { Plant } from 'src/app/classes/plant';
import { PlantUser } from 'src/app/classes/plant-user.model';
import { UserAccount } from 'src/app/classes/user-account';
import { FormControl, FormGroup } from '@angular/forms';
import { AuthenticateService } from 'src/app/authenticate/services/authenticate.service';

@Component({
  selector: 'app-library-list',
  templateUrl: './library-list.component.html',
  styleUrls: ['./library-list.component.scss']
})
export class LibraryListComponent implements OnInit {
  plants: Plant[] = [];
  plantsUsers: PlantUser[] = [];
  userAccount = new UserAccount();

  searchPlantFrom = new FormGroup({
    plantName: new FormControl()
  });

  constructor(private libraryService: LibraryService, public authServ: AuthenticateService) {}

  ngOnInit() {
    this.libraryService.findAllPlants().subscribe(response => {
      console.log(response);
      this.plants = response;
    });

    this.authServ.user$.subscribe(userAuth => this.libraryService.findByCreator(userAuth.nickname).subscribe(response => {
      console.log(response);
      this.plantsUsers = response;
    }));
    // this.libraryService.findByCreator(this.userAccount.nickname).subscribe(response => {
    //   console.log(response);
    //   this.plantsUsers = response;
    // });
  }

  searchPlant() {
    this.libraryService
      .searchByCommonNameOrScientificName(this.searchPlantFrom.value.plantName)
      .subscribe(response => (this.plants = response));
  }
}
