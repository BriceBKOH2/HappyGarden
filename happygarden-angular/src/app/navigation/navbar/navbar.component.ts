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
    {
      // Example of a restricted area. Guards require to be logged in, then to have admin role.
      route: 'admin',
      label: 'Example restricted area'
    }
  ];

  // links that need the user to be logged in to view
  linksAuth = [
    // {
    //   route: 'gardens',
    //   label: 'Mes jardins'
    // },
    {
      route: 'userAccount',
      label: 'Mon Compte'
    }
  ];

  // links that require the user to have admin role to see.
  linksAdmin = [
    {
      route: 'admin',
      label: 'Admin Menu'
    }
  ];

  constructor(public authServ: AuthenticateService, private router: Router) {}

  ngOnInit() {}

  logOut() {
    if (confirm('Se déconnecter ?')) {
      this.authServ.logout().subscribe(
        () => {
          this.router.navigate(['homePage']);
        },
        error => {
          console.log('Error login out' + error);
          alert(error.status + ' : ' + error.statusText);
        }
      );
    }
  }
}
