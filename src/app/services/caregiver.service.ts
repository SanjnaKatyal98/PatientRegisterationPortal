import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { userList } from '../admin-dashboard/userList';

@Injectable({
  providedIn: 'root'
})
export class CaregiverService {
  private getUrl: string = "http://localhost:8080/user/all";
  constructor(private http:HttpClient) {}
  cglist:userList[]=[];

  getCare(): Observable<userList[]> {
    return this.http.get<userList[]>(this.getUrl).pipe(
      map(response => response)
    )
  }

  delAll(){
    this.cglist=[];
  }
}