import { Component, OnInit } from '@angular/core';
import { MovieService } from '../../movie.service';
import {Movie} from '../../movie';
import {ActivatedRoute} from'@angular/router';
@Component({
  selector: 'movie-tmdb-container',
  template: `
    <movie-container [movies]="movies"></movie-container>
  `,
  styles: []
})
export class TmdbContainerComponent implements OnInit {
  movies : Array<Movie>;
  movieType:string;
  constructor(private route :ActivatedRoute,private movieService:MovieService) { 
    this.movies=[];
    this.route.data.subscribe((dataum)=>{
      this.movieType=dataum.movieType;
     
    });
  }

  ngOnInit() {
    this.movieService.getMovies(this.movieType).subscribe((movies)=>{
      this.movies.push(...movies);
 
    });
  }

}
