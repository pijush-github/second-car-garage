export class CarDetail {
    
    id: string;
    parentId: string;
    make: string;
    model: string;
    year_model: string;
    price: string;
    licensed: string;
    date_added: string;
    location: string;
    name: string;

    constructor(id: string, parentId: string, make: string, model: string, year_model: string, price: string, licensed: string, date_added: string, location: string, name: string) {
        this.id = id;
        this.parentId = parentId;
        this.make = make;
        this.model = model;
        this.year_model = year_model;
        this.price = price;
        this.licensed = licensed;
        this.date_added = date_added;
        this.location = location;
        this.name = name;
    }
}
