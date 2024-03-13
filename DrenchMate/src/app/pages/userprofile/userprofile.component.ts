import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-userprofile',
  templateUrl: './userprofile.component.html',
  styleUrls: ['./userprofile.component.scss']
})
export class UserprofileComponent {

  UserDto: any={
    "userId":"",
    "name":"",
    "email":"",
    "displayName":"",
    "avator":"",
    "phoneNo":"",
    "facebookLink":"",
    "twitterLink":"",
    "remarks":"",
    "noofdays":"",
    "message":"",
    "status":""
  }

  user:any;
  constructor(private http:HttpClient,private router: Router){
    this.loadUser();
  }

  loadUser(){

    this.http.get('http://localhost:8080/api/v1/dm/user/'+localStorage.getItem("userid")).subscribe((res:any)=>{
      this.UserDto.userId=res.userId;
      this.UserDto.name=res.name;
      this.UserDto.email=res.email;
      this.UserDto.displayName=res.displayName;
      this.UserDto.avator=res.avator;
      this.UserDto.phoneNo=res.phoneNo;
      this.UserDto.facebookLink=res.facebookLink;
      this.UserDto.twitterLink=res.twitterLink;
      this.UserDto.remarks=res.remarks;
      this.UserDto.noofdaysToNoti=res.noofdaysToNoti;
    })

  }

  updateUser(user:any){
   // debugger;
    this.http.post("http://localhost:8080/api/v1/dm/user/update/"+user.userId,user).subscribe((res:any)=>{
     try {
     // debugger;
      if(res.status=='Success'){
        alert('Updated success' + res.message+" " + res.status) 
        this.router.navigateByUrl('dashboard')
      }else {
      //  debugger
        alert('Updated failed ' + res.message+" " + res.status);
      }
     } catch (error) {
      alert(res.message);
     } 
    })

  }
  

}
