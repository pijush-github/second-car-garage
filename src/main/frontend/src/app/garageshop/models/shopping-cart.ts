export class ShoppingCart {

    totalCartAmount: string;
    allCartItems: string[];

    constructor(totalCartAmount: string, allCartItems: string[]) {
        this.totalCartAmount = totalCartAmount;
        this.allCartItems = allCartItems;
    }
}
