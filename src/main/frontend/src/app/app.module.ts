import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http'; 
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';
import { GarageshopComponent } from './garageshop/garageshop.component';
import { CarsComponent } from './garageshop/cars/cars.component';
import { CarDetailsComponent } from './garageshop/cars/car-details.component';
import { AppRoutingModule } from './app-routing.module';
import { ShoppingCartComponent } from './garageshop/shopping-cart/shopping-cart.component';

@NgModule({
  declarations: [
    AppComponent,
    GarageshopComponent,
    CarsComponent,
    CarDetailsComponent,
    ShoppingCartComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    HttpModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
