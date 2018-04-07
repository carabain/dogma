import { Injectable } from '@angular/core';
import {Subject} from 'rxjs/Subject';

@Injectable()
export class UserService {

  user:Subject<string> = new Subject<string>();
  username;
  redirectUrl;

  constructor() {
    this.user.subscribe(result => this.username = result);
  }

}
