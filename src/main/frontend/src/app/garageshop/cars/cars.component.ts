import { Component, OnInit } from '@angular/core';
import { GarageshopService } from "../services/garageshop.service";
import { Subscription } from "rxjs/internal/Subscription";
import { Car } from "../models/car";
import { Router } from '@angular/router';

@Component({
  selector: 'app-cars',
  templateUrl: './cars.component.html',
  styleUrls: ['./cars.component.css']
})
export class CarsComponent implements OnInit {

  cars: Car[] = [];
  sub: Subscription;
  carSelected: boolean = false;

  constructor(private garageshopService: GarageshopService, private angRouter: Router) {
  }

  ngOnInit() {
    this.loadAllCars();
  }

  loadAllCars() {
    this.garageshopService.getAllCars()
      .subscribe(
        (cars: any[]) => {
          this.cars = cars;
        },
        (error) => console.log(error)
      );
  }

  pullCarDetail(car: Car) {
    this.angRouter.navigate(['/cardetail', car.parentId, car.id]);
  }

}
