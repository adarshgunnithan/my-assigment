import { Component, OnInit } from '@angular/core';
import { MovieService } from '../../movie.service';
import {Movie} from '../../movie';

@Component({
  selector: 'movie-watchlist',
  template: `
   <movie-container [movies]="movies" [useWatchListApi]='useWatchListApi'></movie-container>
  `,
  styles: []
})
export class WatchlistComponent implements OnInit {
  movies :Array<Movie>;
  useWatchListApi : boolean = true;

  constructor(private movieService : MovieService) { 
    this.movies=[];
  }

  ngOnInit() {
    this.movieService.getWatchListedMovies().subscribe((movies)=>{
  this.movies.push(...movies);  
    });
  }

}
