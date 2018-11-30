import {EventEmitter, Injectable, Output} from '@angular/core';
import {User} from '../User.model';

@Injectable({
  providedIn: 'root'
})
export class ProfileService {

  constructor() { }

  private _user: User;

  get user(): User {
    return this._user;
  }

  set user(value: User) {
    this._user = value;
  }
}
