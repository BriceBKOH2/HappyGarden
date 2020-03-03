import { Component, OnInit } from '@angular/core';
import { Garden } from 'src/app/classes/garden';
import { UserAccount } from 'src/app/classes/user-account';
import { PlantingArea } from 'src/app/classes/planting-area';
import { Plant } from 'src/app/classes/plant';
import { Slot } from 'src/app/classes/slot';
import { Observable, forkJoin } from 'rxjs';
import { UserAccountRequestService } from 'src/app/services/userAccountRequest/user-account-request.service';
import { AuthenticateService } from 'src/app/authenticate/services/authenticate.service';
import { untilDestroyed } from 'ngx-take-until-destroy';
import { map, switchMap } from 'rxjs/operators';
import { GardenService } from '../services/garden.service';

@Component({
  selector: 'app-my-gardens',
  templateUrl: './my-gardens.component.html',
  styleUrls: ['./my-gardens.component.scss']
})
export class MyGardensComponent implements OnInit {
  gardens$: Observable<Garden[]>;
  userAccount: UserAccount;
  currentGarden: Garden;
  currentPlantingArea: PlantingArea;
  currentSlot: Slot;
  currentPlant: Plant;
  plant: Plant;
  addButtonTitle: String;
  createRouter: String;

  constructor(
    private userAccServ: UserAccountRequestService,
    private authServ: AuthenticateService,
    private gardenServ: GardenService
  ) {}

  ngOnInit() {
    this.currentGarden = new Garden('');
    this.currentPlantingArea = new PlantingArea();
    this.currentSlot = new Slot();
    this.currentPlant = new Plant();
    this.plant = new Plant();
    this.addButtonTitle = 'Ajouter un jardin';
    this.createRouter = '/create/garden';

    // this.gardens$ = this.userAccServ.getGardens()

    this.gardens$ = this.authServ.user$.pipe(
      map(response => response.id),
      switchMap(id => this.userAccServ.getGardens(id))
    );

    // this.gardens$ = this.authServ.user$.pipe(
    //   map(response => response.id),
    //   switchMap(id => this.userAccServ.getGardens(id)),
    //   switchMap(gardens => {
    //     let gardensWithPlantingAreasWithNbSlots: Garden[] = [];
    //     gardens.forEach(garden => {
    //         const plantingAreaWithNbSlots: Observable<any>[] = [];
    //         garden.plantingAreas.forEach(plantingArea => {
    //           plantingAreaWithNbSlots.push(
    //             this.gardenServ.countSlots(plantingArea.id).pipe(
    //               map(nbSlots => {
    //                 plantingArea.nbSlots = nbSlots;
    //                 return plantingArea;
    //               })
    //             )
    //           );
    //         });
    //         return forkJoin(plantingAreaWithNbSlots);
    //     });
    //     return gardens;
    //   })
    // );
    // switchMap(plantingAreas => {
    //   const plantingAreaWithNbSlots: Observable<any>[] = [];
    //   plantingAreas.forEach(plantingArea => {
    //     plantingAreaWithNbSlots.push(
    //       this.gardenServ.countSlots(plantingArea.id).pipe(
    //         map(nbSlots => {
    //           plantingArea.nbSlots = nbSlots;
    //           return plantingArea;
    //         })
    //       )
    //     );
    //   });
    //   return forkJoin(plantingAreaWithNbSlots);
    // }),
  }

  showGardens() {
    this.addButtonTitle = 'Ajouter un jardin';
    this.createRouter = '/create/garden';
    this.currentGarden = new Garden('');
    this.currentPlantingArea = new PlantingArea();
    this.currentSlot = new Slot();
    this.currentPlant = new Plant();
  }

  selectGarden(garden: Garden) {
    if (!this.currentGarden || this.currentGarden !== garden) {
      this.currentGarden = garden;
      this.currentPlantingArea = new PlantingArea();
      this.currentSlot = new Slot();
      this.currentPlant = new Plant();
      console.log('garden first if ' + garden.id);
    } else {
      this.currentPlantingArea = new PlantingArea();
      this.currentSlot = new Slot();
      this.currentPlant = new Plant();
      console.log('garden else');
    }
    console.log(
      'SelectGarden - gardenId :' +
        this.currentGarden.id +
        ' plantingAreaId :' +
        this.currentPlantingArea.id +
        ' plantId :' +
        this.currentPlant.id
    );
    this.addButtonTitle = 'Ajouter une zone de plantation';
    this.createRouter = '/create/' + this.currentGarden.id + '/plantingArea';
    console.log(this.createRouter);
  }

  selectPlantingArea(event, plantingArea: PlantingArea) {
    console.log(event);
    event.stopPropagation();
    if (
      !this.currentPlantingArea ||
      this.currentPlantingArea !== plantingArea
    ) {
      this.currentPlantingArea = plantingArea;
      this.currentPlant = new Plant();
      this.currentSlot = new Slot();
    } else {
      this.currentPlant = new Plant();
      this.currentSlot = new Slot();
    }
    console.log(
      'SelectPlantingArea - gardenId :' +
        this.currentGarden.id +
        ' plantingAreaId :' +
        this.currentPlantingArea.id +
        ' plantId :' +
        this.currentPlant.id
    );

    this.addButtonTitle = 'Ajouter une plante';
    this.createRouter = '/create/' + this.currentPlant + '/plant';
  }

  selectPlant(event, slot: Slot) {
    console.log(event);
    event.stopPropagation();
    if (!this.currentPlant.id || this.currentPlant.id !== slot.plant.id) {
      this.currentSlot = slot;
      this.currentPlant = slot.plant;
    }
    // else {
    //   this.currentPlant = new Plant;
    // }
    console.log(
      'SelectPlantingArea - gardenId :' +
        this.currentGarden.id +
        ' plantingAreaId :' +
        this.currentPlantingArea.id +
        ' plantId :' +
        this.currentPlant.id
    );
  }

  ngOnDestroy() {}
}
