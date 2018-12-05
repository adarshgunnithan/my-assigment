import { Component, OnInit } from '@angular/core';
import { MovieService } from '../../movie.service';
import {Movie} from '../../movie';
import {ActivatedRoute} from'@angular/router';
@Component({
  selector: 'movie-popular',
  templateUrl: './popular.component.html'
})
export class PopularComponent implements OnInit {
  movies :Array<Movie>;
  constructor(private movieService :MovieService,private route :ActivatedRoute) {
    this.movies=[];
   }

  ngOnInit() {
  
    }
  }


