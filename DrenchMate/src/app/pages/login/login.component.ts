import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent {

  loginObj: any={
    "email":"",
    "password":""
  }


  signupObj: any={
    "userName":"",
    "email":"",
    "password":""
  }
  



  constructor(private http:HttpClient,private router: Router){

  }

  onSignUp(){
    
    this.http.post("http://localhost:8080/api/v1/register",this.signupObj).subscribe((res:any)=>{
     try {
      debugger;
      if(res.status=='Success'){
        alert('Register success' + res.message+" " + res.status) 
        
        this.router.navigateByUrl('dashboard')
      }else {
        debugger
        alert('login failed ' + res.message+" " + res.status);
      }
     } catch (error) {
      alert(res.message);
     } 
    })

  }

  onLogin(){
    this.http.post("http://localhost:8080/api/v1/login",this.loginObj).subscribe((res:any)=>{
     try {
      debugger;
      if(res.status=='Success'){
        alert('login success' + res.message+" " + res.status) 
        localStorage.setItem('token',res.token);
        localStorage.setItem('userid',res.userid);
        localStorage.setItem('displayname',res.displayname);
        this.router.navigateByUrl('dashboard')
      }else {
        debugger
        alert('login failed ' + res.message+" " + res.status);
      }
     } catch (error) {
      alert(res.message);
     } 
    })
  }

}
