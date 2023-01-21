import { Injectable } from "@angular/core";
import { HttpClient } from '@angular/common/http';
import { Observable } from "rxjs";
import { Oggetti } from "./oggetti";
import { enviroment } from "../enviroments/enviroment";

@Injectable({
    providedIn: 'root'
})
export class OggettiService{
    private apiServerUrl = enviroment.apiBaseUrl;
    constructor (private http: HttpClient){ }

    public getAllOggetti(): Observable<Oggetti[]>{
      return this.http.get<Oggetti[]>(`${this.apiServerUrl}/oggetti/all`);
      }

    
    }
