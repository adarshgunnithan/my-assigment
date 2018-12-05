import { Component } from '@angular/core';
import { ThumbnailComponent } from './modules/movie/components/thumbnail/thumbnail.component';
import { AuthenticationService } from './modules/authentication/authentication.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-root',
  template: `
  <mat-toolbar color="primary">
  <span>Movie Cruiser Application</span>
  <button mat-button [routerLink]="['./movies/popular']">Popular Movies</button>
  <button  mat-button [routerLink]="['./movies/top-rated']">Top Rated Movies</button>
  <button  mat-button [routerLink]="['./movies/watchlist']">Watch List</button>
<button  mat-button [routerLink]="['./movies/search']" class="search-button">Search</button>
<button mat-buton (click)="Logout()">Logout</button>
  </mat-toolbar>
  <router-outlet></router-outlet>
  `,
  styles: []
})
export class AppComponent {
  title = 'app';

  constructor(private auth:AuthenticationService, private routes:Router){}
  Logout(){
    this.auth.deleteToken();
    this.routes.navigate(['/login']);
  }
}
