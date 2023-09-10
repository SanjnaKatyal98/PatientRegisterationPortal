import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit{
  ngOnInit(): void {}
  constructor(private router:Router,private usrServ:UserService){}

  public user={
    username:'',
    password:'',
    age:'',
    fullname:'',
    gender:'',
    dob:'',
    medDev:'',
    plan:'',
    regDate:'',
    expDate:''
  };

  onSubmit(regForm:NgForm){
    alert('Registeration Successful!! Welcome!!');
    console.log('success');
    console.log(regForm.value);
    console.log(this.user);
    this.router.navigate(['login']);
    //add user ko call krenge jo user service se aa raha hai
    //this is binding with backend
    this.usrServ.addUSer(this.user).subscribe(
      (data)=>{
        //success
        console.log(data);
        alert('welcome!');
      },
      (err)=>{
        //fail
        console.log(err);
        alert('error!something is wrong!');
      }
    );
  }
  
  reset(regForm:NgForm){
    regForm.resetForm();
  }

  back(){
    console.log('no changes made');
    this.router.navigate(['login']);
  }
}