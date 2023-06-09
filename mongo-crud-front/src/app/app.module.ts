import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AppRoutingModule } from './app-routing.module';

import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import {HttpClientModule} from '@angular/common/http';
import {FormsModule} from '@angular/forms';
import { RouterModule } from '@angular/router';
//Components
import { ListComponent } from './product/list.component';
import { DetailComponent } from './product/detail.component';
import { CreateComponent } from './product/create.component';
import { UpdateComponent } from './product/update.component';
import { MenuComponent } from './menu/menu.component'; 

//External
import { SweetAlert2Module } from '@sweetalert2/ngx-sweetalert2';
import { ToastrModule } from 'ngx-toastr';


@NgModule({
  declarations: [
    AppComponent,
    ListComponent,
    DetailComponent,
    CreateComponent,
    UpdateComponent,
    MenuComponent
  ],
  imports: [
    CommonModule,
    AppRoutingModule,
    BrowserModule,
    SweetAlert2Module.forRoot(),
    BrowserAnimationsModule,
    ToastrModule.forRoot(),
    HttpClientModule,
    FormsModule,
    RouterModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})

export class AppModule { }





