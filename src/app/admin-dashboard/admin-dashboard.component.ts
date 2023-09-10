import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { userList } from './userList';
import { CaregiverService } from '../services/caregiver.service';

@Component({
  selector: 'adminDashboard',
  templateUrl: './admin-dashboard.component.html',
  styleUrls: ['./admin-dashboard.component.css']
})
export class AdminDashboardComponent implements OnInit{
  ngOnInit(): void {
    this.listCare();//with DB
  }
  constructor(private router:Router,private serv:CaregiverService){}
  title="Admin";

  //initialisation
  searchText!:string;//for searching all
  cglist:userList[]=[];

  listCare() {
    this.serv.getCare().subscribe(
      data => this.cglist = data
    );
  }

  //fixed data
  /*cglist:userList[]=[{
    id:1,
    fullname:"Taylor",
    regDate:"Swift"
  },{
    id:2,
    fullname:"Selena",
    regDate:"Gomez"
  },{
    id:3,
    fullname:"Ed",
    regDate:"Sheeran"
  },{
    id:4,
    fullname:"Ariana",
    regDate:"Grande"
  },{
    id:5,
    fullname:"AP",
    regDate:"Dhillon"
  }];*/ 
  
  logout(){
    console.log('logged out');
    this.router.navigate(['login']);
  }

  back(){
    console.log('no changes made');
    this.router.navigate(['home']);
  }

  delete(){
    console.log("delete");
    //for deleting all users
    this.serv.delAll();
  }
}