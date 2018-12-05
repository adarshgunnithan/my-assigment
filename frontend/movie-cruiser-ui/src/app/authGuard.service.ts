import { Injectable } from '@angular/core';


import {Observable} from 'rxjs/Observable';

import { CanActivate } from '@angular/router/src/interfaces';
import { AuthenticationService } from './modules/authentication/authentication.service';
import { Router } from '@angular/router';


@Injectable()
export class AuthGuardService implements CanActivate {


  constructor(private router:Router,private auth: AuthenticationService) {

  }

  canActivate(){
      if(!this.auth.isTokenExpired()){
          return true;
      }
      this.router.navigate(['/login']);
      return false;
  }
  
}