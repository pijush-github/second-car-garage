import { Subject } from "rxjs/internal/Subject";
import { HttpClient } from '@angular/common/http';
import { Injectable } from "@angular/core";

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

}
