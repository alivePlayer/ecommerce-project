import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule } from '@angular/router';

import { AppComponent } from './app.component';
import { OggettiService } from './oggetti/oggetti.service';
import { UserLoginComponent } from './user-login/user-login.components';
import { RegisterUserComponent } from './register-user/register-user.components';
import { AppRoutingModule } from './app-routing.module';
import { HomeComponent } from './home/home.component';


@NgModule({
  declarations: [
    AppComponent,
    UserLoginComponent,
    RegisterUserComponent,
    HomeComponent,

  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    FormsModule,
    RouterModule.forRoot([
      {path: 'home', component : OggettiService }
    ])
  ],
  providers: [OggettiService],
  bootstrap: [AppComponent]
})
export class AppModule { }
