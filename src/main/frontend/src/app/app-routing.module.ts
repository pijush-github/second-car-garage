import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CarDetailsComponent } from './garageshop/cars/car-details.component';
import { CarsComponent } from './garageshop/cars/cars.component';

const appRoutes: Routes = [
  { path: 'cars', component: CarsComponent },
  { path: 'cardetail/:parent/:id', component: CarDetailsComponent },
  { path: '', redirectTo: '/cars', pathMatch: 'full' }
];

@NgModule({
  imports: [
    RouterModule.forRoot(appRoutes)
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
