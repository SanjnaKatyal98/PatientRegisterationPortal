import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'userDashboard',
  templateUrl: './user-dashboard.component.html',
  styleUrls: ['./user-dashboard.component.css']
})
export class UserDashboardComponent implements OnInit{
  ngOnInit(): void {}
  constructor(private router:Router){}
  
  renewP(){
    this.router.navigate(['renewPage']);
  }

  logout(){
    console.log('logged out');
    this.router.navigate(['login']);
  }

  back(){
    console.log('no changes made');
    this.router.navigate(['home']);
  }
}