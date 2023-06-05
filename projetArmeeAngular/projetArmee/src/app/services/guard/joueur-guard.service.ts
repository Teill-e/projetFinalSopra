import { Injectable } from '@angular/core';
import { AuthenticationService } from '../authentication.service';
import {
  ActivatedRouteSnapshot,
  RouterStateSnapshot,
  UrlTree,
} from '@angular/router';

@Injectable({
  providedIn: 'root',
})
export class JoueurGuardService {
  constructor(private authSrv: AuthenticationService) {}

  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot
  ): boolean | UrlTree {
    return this.authSrv.isJoueur();
  }
}
