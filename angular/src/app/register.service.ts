import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { User } from "./user";

@Injectable({
  providedIn:'root'
})
export class RegisterService{
  baseUrl="http://localhost:8080/user/registrati";
  constructor(private httpCliente:HttpClient){}

  registerUser(user:User): Observable<Object>{
    return this.httpCliente.post(`${this.baseUrl}`,user);
  }
}



