import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { User } from "./user";
import { HttpClient } from "@angular/common/http";
import { enviroment } from "./enviroment";
@Injectable
({
  providedIn:'root'
})
export class loginUserService{

  private baseUrl= enviroment.apiBaseUrl;

  constructor(private httpClient:HttpClient ){}

    loginUserService(user:User):Observable<object> {
      console.log(user);
      return this.httpClient.post(`${this.baseUrl}/user/login`,user);
    }


    logoutUserService(user:User):Observable<object> {
      console.log(user);
      return this.httpClient.post(`${this.baseUrl}/user/logout`,user);
    }

  }



