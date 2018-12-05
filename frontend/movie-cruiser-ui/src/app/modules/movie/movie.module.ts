import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ThumbnailComponent } from './components/thumbnail/thumbnail.component';
import {Movie} from './movie';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import {MovieService} from './movie.service';
import { ContainerComponent } from './components/container/container.component';
import {Routes,RouterModule} from '@angular/router';
import {MovieRouterModule} from './movie-router.module'
import{MatCardModule} from '@angular/material/card';
import { WatchlistComponent } from './components/watchlist/watchlist.component';
import { TmdbContainerComponent } from './components/tmdb-container/tmdb-container.component';
import { MatButtonModule } from '@angular/material/button';
import {MatSnackBarModule} from '@angular/material/snack-bar';
import { MovieDialogComponent } from './components/movie-dialog/movie-dialog.component';
import {MatDialogModule} from '@angular/material/dialog';
import {MatInputModule} from '@angular/material/input';
import { FormsModule } from '@angular/forms';
import { TopRatedComponent } from './components/top-rated/top-rated.component';
import { PopularComponent } from './components/popular/popular.component';
import  {SearchComponent} from './components/search/search.component';
import {TokenInterceptor} from './interceptor.service';
import { HTTP_INTERCEPTORS } from '@angular/common/http';

//
@NgModule({
  imports: [
    CommonModule,
    HttpClientModule,
    MovieRouterModule,
    MatCardModule,
    MatButtonModule,
    MatSnackBarModule,
    MatDialogModule,
    MatInputModule,
    FormsModule,
    MatInputModule,
    MovieRouterModule
  ],
  entryComponents:[MovieDialogComponent],
  declarations: [ThumbnailComponent, ContainerComponent, WatchlistComponent, TmdbContainerComponent, MovieDialogComponent,TopRatedComponent,PopularComponent,SearchComponent],
  exports:[ThumbnailComponent,ContainerComponent,MovieRouterModule,MovieDialogComponent,SearchComponent],
  providers:[MovieService,{
    provide:HTTP_INTERCEPTORS,
    useClass: TokenInterceptor,
    multi:true
   }]
})
export class MovieModule { 



}
