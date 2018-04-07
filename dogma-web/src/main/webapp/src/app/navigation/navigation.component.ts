import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {MenuItem} from 'primeng/api';
import {UserService} from '../shared/services/user.service';

@Component({
  selector: 'app-navigation',
  templateUrl: './navigation.component.html',
  styleUrls: ['./navigation.component.css']
})
export class NavigationComponent implements OnInit {

  username;
  showDropDown = false;
  items: MenuItem[];

  constructor(private userService: UserService, private router:Router) {
    this.userService.user.subscribe(result => this.username = result);
  }

  ngOnInit() {
    this.items = [{label: 'Logout', command: (event) => {
        this.userService.user.next(undefined);
        this.router.navigate(['']);
      }}];
  }


  logout(){
    this.userService.user.next(undefined);
  }
}
