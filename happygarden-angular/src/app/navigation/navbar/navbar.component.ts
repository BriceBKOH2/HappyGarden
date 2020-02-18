import { Component, OnInit } from '@angular/core';
import { AuthenticateService } from 'src/app/authenticate/services/authenticate.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent implements OnInit {
  isNavbarCollapsed = true;

  links = [
    {
      route: 'homePage',
      label: 'Accueil'
    },
    {
      route: 'libraryList',
      label: 'Bibliothèque'
    },
    // {
    //   route: 'login',
    //   label: 'Log in'
    // },
  ];

  // links that need the user to be logged in to view
  linksAuth = [
    {
      route: 'gardenList',
      label: 'Mes jardins'
    },
    {
      route: 'userAccount',
      label: 'Mon Compte'
    },
  ];

  linksAdmin = [
    {
      route: 'usermanagement',
      label: 'Gestion des utilisateurs'
    },
  ]

  constructor(public authServ: AuthenticateService,
              private router: Router) {}

  ngOnInit() {}

  logOut() {
    this.authServ.logout().subscribe(
      () => {
        this.router.navigate(['login']);
      },
      error => {
        console.log('Error login out' + error);
        alert(error.status + ' : ' + error.statusText);
      }
    );
  }
}
