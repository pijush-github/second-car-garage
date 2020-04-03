export class Car {

    id: string;
    parentId: string;
    make: string;
    model: string;
    year_model: string;
    price: string;
    licensed: string;
    date_added: string;
    inCart: string;

    constructor(id: string, parentId: string, make: string, model: string, year_model: string, price: string, licensed: string, date_added: string, inCart: string) {
        this.id = id;
        this.parentId = parentId;
        this.make = make;
        this.model = model;
        this.year_model = year_model;
        this.price = price;
        this.licensed = licensed;
        this.date_added = date_added;
        this.inCart = inCart;
    }
}
