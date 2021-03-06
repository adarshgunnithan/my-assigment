import { Component, OnInit } from '@angular/core';
import {User} from './../User';
import {AuthenticationService} from './../authentication.service';
import{Router} from '@angular/router';

@Component({
  selector: 'auth-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  newUser:User;
  constructor(private authService:AuthenticationService, private router:Router) { 
    this.newUser= new User();
  }

  ngOnInit() {
  }

  registerUser(){
    
  this.authService.registerUser(this.newUser).subscribe((data)=>{
      this.router.navigate(['/login']);
    })
  }

  resetInput(){
    this.newUser=null;
  }

}