import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {map} from 'rxjs/operators/map';
import { Observable } from 'rxjs/Observable';
import {Movie} from './movie';

@Injectable()
export class MovieService {

  tmdbEndpoint :string;
  watchListEndpoint :string;
  imagePrefix:string;
  apiKey:string;
  springEndpoint : string;
  search : string;
  getEndpoint :string;

  constructor(private http:HttpClient) { 

    this.tmdbEndpoint='https://api.themoviedb.org/3/movie';
    this.imagePrefix='https://image.tmdb.org/t/p/w500/';
    this.apiKey='api_key=7ca8088fbc393e717d421c01211e2550';
    //this.watchListEndpoint='http://localhost:3000/watchlist';
    //add watchlist
    this.watchListEndpoint='http://localhost:8080/api/v1/movie/add';
    //get watchlist
    this.getEndpoint='http://localhost:8080/api/v1/movies';
    this.springEndpoint='http://localhost:8080/api/v1/';
    this.search='https://api.themoviedb.org/3/search/movie?';
  }


  getMovies(type:string,page: number=1): Observable<Array<Movie>>{
    const getMoviesEndpoint =`${this.tmdbEndpoint}/${type}?${this.apiKey}&page=${page}`
    
    return this.http.get(getMoviesEndpoint).pipe(
      map(this.pickResults),
      map(this.transformPosterPath.bind(this)),
    );
  }

  transformPosterPath(movies): Array<Movie>{
   return movies.map(movie=>{
      movie.poster_path= `${this.imagePrefix}${movie.poster_path}`;
      return movie;
    })
  }

  pickResults(response){
    return response['results'];
  }

  addMoviesToWatchList(movie){
    return this.http.post(this.watchListEndpoint,movie);
  }

  getWatchListedMovies() :Observable<Array<Movie>>{
    //return this.http.get<Array<Movie>>(this.watchListEndpoint);
        return this.http.get<Array<Movie>>(this.getEndpoint);
  }
deleteMovieFromWatchList(movie: Movie){
  console.log("delete",movie);
  const url =`${this.springEndpoint}movie/delete/${movie.id}`;
  return this.http.delete(url,{responseType:'text'});
}

updateComments(movie: Movie){
    const url =`${this.springEndpoint}movie/update/${movie.movieId}`;
     return this.http.put(url,movie);
}


  pickMovieResults(response) {
    return response['results'];
  }

  searchMovies(searchKey: string, page: number = 1): Observable<Array<Movie>> {
    if (searchKey.length > 0) {
    const url=`${this.search}${this.apiKey}&language=en-US&page=1&include_adult=false&query=${searchKey}`;
      return this.http.get(url).pipe(
        map(this.pickMovieResults),
        map(this.transformPosterPath.bind(this))
      );
    }
    return null;
  }
  }


