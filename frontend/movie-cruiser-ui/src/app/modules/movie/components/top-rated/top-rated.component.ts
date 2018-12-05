import { Component, OnInit } from '@angular/core';
import { MovieService } from '../../movie.service';
import {Movie} from '../../movie';

@Component({
  selector: 'movie-top-rated',
  templateUrl:'./top-rated.component.html'

})
export class TopRatedComponent implements OnInit {

  movies :Array<Movie>;

  constructor(private movieService :MovieService) { 
    this.movies=[];
  }

  ngOnInit() {

  }

}
