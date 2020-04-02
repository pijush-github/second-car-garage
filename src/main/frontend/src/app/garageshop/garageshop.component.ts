import { Component, OnInit, ViewChild } from '@angular/core';
import { CarsComponent } from "./cars/cars.component";

@Component({
  selector: 'app-garageshop',
  templateUrl: './garageshop.component.html',
  styleUrls: ['./garageshop.component.css']
})
export class GarageshopComponent implements OnInit {

  private collapsed = true;
  orderFinished = false;

  @ViewChild('carsC')
  carsC: CarsComponent;

  constructor() {
  }

  ngOnInit() {
  }

  toggleCollapsed(): void {
    this.collapsed = !this.collapsed;
  }

  finishOrder(orderFinished: boolean) {
    this.orderFinished = orderFinished;
  }

  reset() {
    this.orderFinished = false;
    //this.carsC.reset();
  }

}
