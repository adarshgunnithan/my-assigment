
import { Component, OnInit ,Inject } from '@angular/core';
import {MatSnackBar} from '@angular/material/snack-bar';
import {MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material/dialog';
import {MovieService} from '../../movie.service';
import {Movie} from '../../movie';


@Component({
  selector: 'movie-movie-dialog',
  templateUrl: 'movie-dialog.component.html',
  styleUrls:['./movie-dialog.component.css']

})
export class MovieDialogComponent implements OnInit {

  
  movie: Movie;
  comments: string;
  actionType: string;
  constructor(private snackBar: MatSnackBar, private dialogRef: MatDialogRef<MovieDialogComponent>,
    @Inject(MAT_DIALOG_DATA) private data: any, private movieService: MovieService, 
  ) {
    this.movie = data.obj;
    this.actionType = data.actionType;
    this.comments = data.obj.comments;
  }
//
 

  ngOnInit() {
  }

onNoClick()
  {
    this.dialogRef.close();
  }
  updateComments()
  {
    console.log("comments",this.comments);
    if(this.comments!=null && this.comments.trim().length>0){
      this.movie.comments=this.comments;
      this.dialogRef.close();
      this.movieService.updateComments(this.movie).subscribe(
        (movie) => {
          this.snackBar.open('Watchlist Movie updated ', '', { duration: 2000 }); 
        },
        
      );
    }   
   }
}
