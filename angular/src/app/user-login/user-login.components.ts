import { Component,NgModule,OnInit } from "@angular/core";
import { loginUserService } from "../loginUser.service";
import { User } from "../user";

@Component
({
    selector: 'app-user-login',
    templateUrl:'./user-login.component.html',
    styleUrls:['./user-login.component.css'],
})



export class UserLoginComponent implements OnInit{


  user:User=new User();
  haLoggato=false;
    constructor(private loginUserService:loginUserService){}

    ngOnInit(): void {

    }

    userLogin(){

      this.loginUserService.loginUserService(this.user).subscribe(data=>{
        this.haLoggato=true;
        alert("accesso Eseguito")


      },
      error=>alert("credenziali sbagliate"));
    }

    userLogout(){
      this.loginUserService.logoutUserService(this.user).subscribe(data=>{
        this.haLoggato=false;
        this.user.password="";
        this.user.userId="";
      });

    }
    setSession(){
      sessionStorage.setItem('haLoggato',String(this.haLoggato));
    }
    
}
