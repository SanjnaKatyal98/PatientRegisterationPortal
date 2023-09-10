import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-renewal-page',
  templateUrl: './renewal-page.component.html',
  styleUrls: ['./renewal-page.component.css']
})
export class RenewalPageComponent implements OnInit{
  ngOnInit(): void {}
  constructor(private router:Router){}

  onSubmit(planForm:NgForm){
    alert('renewed successfully!');
    console.log('success');
    console.log(planForm.value);
    this.router.navigate(['home']);
  }

  reset(planForm:NgForm){
    planForm.resetForm();
  }
  
  back(){
    console.log('no changes made');
    this.router.navigate(['userDash']);
  }
}