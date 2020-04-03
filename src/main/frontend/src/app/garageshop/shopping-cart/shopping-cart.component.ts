import { Component, OnInit } from '@angular/core';
import { GarageshopService } from "../services/garageshop.service";
import { Subscription } from "rxjs/internal/Subscription";
import { ShoppingCart } from "../models/shopping-cart";
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-shopping-cart',
  templateUrl: './shopping-cart.component.html',
  styleUrls: ['./shopping-cart.component.css']
})
export class ShoppingCartComponent implements OnInit {

  shoppingCart: ShoppingCart;

  constructor(private garageshopService: GarageshopService, private activatedRoute: ActivatedRoute) {
  }

  ngOnInit() {
    this.loadShoppingCartDetail();
  }

  loadShoppingCartDetail(){
    this.garageshopService.getShoppingCartDetail()
    .subscribe(
      (shoppingCart: ShoppingCart) => {
        this.shoppingCart = shoppingCart;
      },
      (error) => console.log(error)
    );
  }

  releaseItems(){
    this.garageshopService.clearCart()
      .subscribe(
        (shoppingCart: ShoppingCart) => {
          this.shoppingCart = shoppingCart;
        },
        (error) => console.log(error)
      );
  }
}
