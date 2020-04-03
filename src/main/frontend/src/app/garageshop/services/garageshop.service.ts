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
 
  constructor(private http: HttpClient) {
  }

  getAllCars() {
    return this.http.get(this.carsUrl);
  }

  getCarDetail(parent: string, id: string) {
    return this.http.get(this.carsUrl +'/'+parent+'/'+id);
  }

}
