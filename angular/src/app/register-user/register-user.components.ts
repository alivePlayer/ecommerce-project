import { Component, OnInit } from "@angular/core";
import { RegisterService } from "../register.service";
import { User } from "../user";

@Component({
  selector:'app-register-user',
  templateUrl:'./register-user.component.html',
  styleUrls: ['./register-user.component.css']
})
export class RegisterUserComponent implements OnInit{


  user:User=new User();
  constructor(private registerService: RegisterService){}
  ngOnInit(): void {

  }
  userRegister(){
      this.registerService.registerUser(this.user).subscribe(data=>{
      alert("iscrizione avvenuta con successo")

      this.user.password="";
      this.user.userId="";
      this.user.cognome="";
      this.user.indirizzo="";
      this.user.nome="";
      this.user.telefono="";


    },error=>alert("utente già iscritto")
    )
  }

}




