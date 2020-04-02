export class Car {

    parentId: string;
    make: string;
    model: string;
    year_model: string;
    price: string;
    licensed: string;
    date_added: string;

    constructor(parentId: string, make: string, model: string, year_model: string, price: string, licensed: string, date_added: string) {
        this.parentId = parentId;
        this.make = make;
        this.model = model;
        this.year_model = year_model;
        this.price = price;
        this.licensed = licensed;
        this.date_added = date_added;
    }
}
