import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CarrelloComponent } from './carrello/carrello.component';
import { HomeComponent } from './home/home.component';
import { RegisterUserComponent } from './register-user/register-user.components';

const routes: Routes = [
 {path: '', component: HomeComponent},
 {path: 'registrati', component: RegisterUserComponent},
 {path:'carrello',component:CarrelloComponent},


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
