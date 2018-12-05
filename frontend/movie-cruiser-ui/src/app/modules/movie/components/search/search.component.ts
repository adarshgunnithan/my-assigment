import { Component, OnInit } from '@angular/core';
import { MovieService } from '../../movie.service';
import {Movie} from '../../movie';
import {ActivatedRoute} from'@angular/router';
@Component({
  selector: 'search-container',
  templateUrl: './search.component.html',
  styleUrls:['./search.component.css']

})
export class SearchComponent implements OnInit {

    movies :Array<Movie>;

  constructor(private movieService :MovieService) { 
    
  }
onEnter(searchKey){
    console.log("searchkey",searchKey);
    this.movieService.searchMovies(searchKey).subscribe(movies=>{
        this.movies = movies;
    });
}
  ngOnInit() {
    
  }

}
