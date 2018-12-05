import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {MovieModule} from './modules/movie/movie.module';
import {Routes,RouterModule} from '@angular/router';
import { AppComponent } from './app.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';

import { MatToolbarModule} from '@angular/material/toolbar';
import {MatButtonModule} from '@angular/material/button';
import {MatDialogModule} from '@angular/material/dialog';
import {AuthenticationModule} from './modules/authentication/authentication.module';
import {AuthGuardService} from './authGuard.service';

const appRoutes :Routes =[

{
  path :'',
  redirectTo:'login',
  pathMatch:'full'
}
];

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    MatDialogModule,
    BrowserModule,
    BrowserAnimationsModule,
    MovieModule,
   MatToolbarModule,
   MatButtonModule,
   AuthenticationModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [AuthGuardService],
  bootstrap: [AppComponent]
})
export class AppModule { }
