import { Component, OnInit } from "@angular/core";
import { Router } from '@angular/router';

@Component({
  selector:"app-carrello",
  templateUrl:"./carrello.component.html",
  styleUrls:["./carrello.components.css"]
})

export class CarrelloComponent implements OnInit{

  constructor(private router:Router){

  }

  ngOnInit(): void {



  }
  toHome(){
    this.router.navigate([''])
  }
}

