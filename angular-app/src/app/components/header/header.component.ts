import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { UserService } from 'src/app/user.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  isAuthenticated: boolean;

  constructor(private service: UserService,private router: Router) { }

  ngOnInit() {
    // this.router.navigate(['signin']);
    this.isLoggedIn();
  }

  logout() {
    this.service.logout();
    this.isAuthenticated = false;
    this.router.navigate(['search']);
}

isLoggedIn(){
  this.isAuthenticated = this.service.isLoggedIn();
  return this.isAuthenticated;
}
}
