import { Subject } from "rxjs/internal/Subject";
import { HttpClient } from '@angular/common/http';
import { Injectable } from "@angular/core";
import { Observable, of } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { CarDetail } from '../models/car-detail';

@Injectable({
  providedIn: 'root'
})
export class GarageshopService {

  private carsUrl = "/api/cars";
  private shoppingCartUrl = "/api/shopping/cart";
 
  constructor(private http: HttpClient) {
  }

  getAllCars() {
    return this.http.get(this.carsUrl);
  }

  getCarDetail(parent: string, id: string) {
    return this.http.get(this.carsUrl +'/'+parent+'/'+id);
  }

  getShoppingCartDetail(){
    return this.http.get(this.shoppingCartUrl);
  }

  addItemToCart(carDetail: CarDetail): Observable<Object> {
    return this.http.post(this.shoppingCartUrl, carDetail);
  }


  removeItemFromCart(parent: string, child: string): Observable<Object> {
    return this.http.delete(this.shoppingCartUrl + '/' + parent + '/' + child);
  }

  clearCart(): Observable<Object> {
    return this.http.delete(this.shoppingCartUrl + '/delete/all');
  }

}
