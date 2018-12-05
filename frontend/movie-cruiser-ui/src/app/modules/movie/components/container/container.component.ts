import { Component, OnInit,Input } from '@angular/core';
import { MovieService } from '../../movie.service';
import {Movie} from '../../movie';
import {ActivatedRoute} from'@angular/router';
import {MatSnackBar} from '@angular/material/snack-bar';
import { MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material';
import {MatDialogModule} from '@angular/material/dialog';
import { MovieDialogComponent } from '../movie-dialog/movie-dialog.component';

@Component({
  selector: 'movie-container',
  templateUrl:'container.component.html',
  styleUrls: ['container.component.css']
})
export class ContainerComponent implements OnInit {
  @Input()
  movies : Array<Movie>;
  @Input()
  useWatchListApi : boolean;
  movieType:string;
  constructor(private movieService: MovieService,private snackBar: MatSnackBar,private matDlg: MatDialog) { 

   
  }
  ngOnInit() {
    
  }

addToWatchList(movie){
this.movieService.addMoviesToWatchList(movie).subscribe((movie)=>{
        console.log(movie);
        this.snackBar.open('Movie Added To Watch List','',{duration:1000})
     });
}


deleteFromWatchList(movie) {
  console.log("deletedddddddd");
 
  let message = `${movie.title} deleted from watchlist`;
  console.log("movie to be deleted",movie);
  let movieId = movie.id;
  for (var i = 0; i < this.movies.length; i++) {
    if (this.movies[i].title == movie.title) {
      this.movies.splice(i, 1);
    }
  }

  //delete from db
  this.movieService.deleteMovieFromWatchList(movie).subscribe((movie)=>{
    this.snackBar.open('Movie deleted','',{duration:1000})
  });
}
 
//  updateMovieFromWatchList(actionType){
    
//   console.log('movie is getting updated');
//   let dialogRef = this.matDlg.open(MovieDialogComponent,
//   {
//     width:"400px",
//     data: {obj: this.movie,actionType: actionType}
//   });
//   console.log("open the dialog");
//   dialogRef.afterClosed().subscribe((results)=>{
//     console.log("this dialog was closed");
//   })
//  }

}
