import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent {

  user:any;
  constructor(private http:HttpClient){
    this.loadUser()
  }

  loadUser(){
   
    this.http.get('http://localhost:8080/api/v1/dm/user/'+localStorage.getItem("userid")).subscribe((res:any)=>{
      this.user=res;
    })
  }

}
