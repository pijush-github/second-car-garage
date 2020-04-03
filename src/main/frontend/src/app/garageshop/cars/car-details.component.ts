import { Component, OnInit } from '@angular/core';
import { GarageshopService } from "../services/garageshop.service";
import { Subscription } from "rxjs/internal/Subscription";
import { CarDetail } from "../models/car-detail";
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-car-details',
  templateUrl: './car-details.component.html',
  styleUrls: ['./car-details.component.css']
})
export class CarDetailsComponent implements OnInit {

  carDetail: CarDetail;

  constructor(private garageshopService: GarageshopService, private activatedRoute: ActivatedRoute) { 
  }

  ngOnInit() {
    this.loadCarDetail();
  }

  loadCarDetail() {
    const parent = this.activatedRoute.snapshot.params['parent'];
    const id = this.activatedRoute.snapshot.params['id'];
    this.garageshopService.getCarDetail(parent, id)
      .subscribe(
        (carDetail: any) => {
          this.carDetail = carDetail;
        },
        (error) => console.log(error)
      );
  }

  addToCart(carDetail: CarDetail) { 
    this.carDetail.isInCart = true;
    this.garageshopService.addItemToCart(carDetail)
      .subscribe(
        (data: any) => {
          console.log(data)
        },
        (error) => {
          console.log(error)
          this.carDetail.isInCart = false;
        }
      );
  }

  deleteFromCart(carDetail: CarDetail) {
    this.carDetail.isInCart = false;
    this.garageshopService.removeItemFromCart(carDetail.parentId, carDetail.id)
      .subscribe(
        (data: any) => {
          console.log(data)      
        },
        (error) => { console.log(error)
        this.carDetail.isInCart = true;
        }
      );
  }


}
