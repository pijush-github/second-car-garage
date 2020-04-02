import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http'; 

import { AppComponent } from './app.component';
import { GarageshopComponent } from './garageshop/garageshop.component';
import { CarsComponent } from './garageshop/cars/cars.component';

@NgModule({
  declarations: [
    AppComponent,
    GarageshopComponent,
    CarsComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
