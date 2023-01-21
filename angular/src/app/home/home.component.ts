import { HttpErrorResponse } from "@angular/common/http";
import { Component, OnInit } from "@angular/core";
import { loginUserService } from "../loginUser.service";
import { Oggetti } from "../oggetti/oggetti";
import { OggettiService } from "../oggetti/oggetti.service";
import { UserLoginComponent } from "../user-login/user-login.components";


@Component({
  selector:'app-home',
  templateUrl:'./home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit{
[x: string]: any;

  public oggetti: Oggetti[] = [];
  oggettiFiltrati: Oggetti[]=[];
  userLoginComponent: UserLoginComponent;

  boolFilter=false;
  stringFilter="";
  boleano="false";
  logged=false

  constructor (private oggettiService: OggettiService){ }
  ngOnInit(): void {
    this.getOggetti();
    this.setSession();



  }

  public getOggetti(){
    this.oggettiService.getAllOggetti().subscribe({
      next:(response: Oggetti[]) => {
        this.oggetti = response.sort((a,b)=>a.name?.localeCompare(b.name!)!);
      },
      error: (e :HttpErrorResponse) => {
          alert(e.message);
      }
    });
  }


  filtra(){

    if(this.stringFilter !==""){

       this.oggetti.filter(oggetti => {

        if(oggetti.name == this.stringFilter){
          this.oggettiFiltrati=[];
          this.boolFilter=true;
          this.oggettiFiltrati.push(oggetti);
        }

      });
    }
    else{
      this.boolFilter=false;
    }

  }

  setSession(){
    this.logged=this.userLoginComponent.haLoggato;
  }
}



