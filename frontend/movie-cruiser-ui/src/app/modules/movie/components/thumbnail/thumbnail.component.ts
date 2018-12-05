import { Component, OnInit, Input,Output,EventEmitter} from '@angular/core';
import {Movie} from '../../movie';
import {HttpClient} from '@angular/common/http';
import { MovieService } from '../../movie.service';
import {MatSnackBar} from '@angular/material/snack-bar';

import { MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material';
import {MatDialogModule} from '@angular/material/dialog';
import { MovieDialogComponent } from '../movie-dialog/movie-dialog.component';


@Component({
  selector: 'movie-thumbnail',
  templateUrl: './thumbnail.component.html',
  styleUrls:['./thumbnail.component.css'],
})
export class ThumbnailComponent implements OnInit {
@Input()
  movie : Movie;
@Input()
useWatchListApi : boolean;
@Output()
addMovie = new EventEmitter();
 @Output()
 deleteMovie = new EventEmitter();
 //@Output()
// updateMovie = new EventEmitter();

  constructor(private movieService: MovieService,private snackBar: MatSnackBar,private matDlg: MatDialog) { 

   
  }
  addToWatchList(){
    this.addMovie.emit(this.movie);
  }
updateMovieFromWatchList (actionType){
  console.log('movie is getting updated');
  let dialogRef = this.matDlg.open(MovieDialogComponent,
  {
    width:"400px",
    data: {obj: this.movie,actionType: actionType}
  });
  console.log("open the dialog");
  dialogRef.afterClosed().subscribe((results)=>{
    console.log("this dialog was closed");
  })
}
deleteFromWatchList(){
    console.log("delete");
  this.deleteMovie.emit(this.movie);
}
// deleteFromWatchList(){
//   console.log("delete triggered");
// this.deleteMovie.emit(this.movie);
// }
  ngOnInit() {
  }

}
