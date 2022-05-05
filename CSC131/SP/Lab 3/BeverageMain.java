package com.company;

public class BeverageMain{
    public static void main(String[] args){

        Customer customer1 = new Customer("Fred");
        //Makes new customers.

        customer1.addDrinkToOrder(new ExtraFroth(new WhippedCream(new Latte(Beverage.Size.SMALL, new NoDiscount()))));
        customer1.addDrinkToOrder(new ExtraShot(new Mocha(Beverage.Size.MEDIUM, new HappyHourDiscount(25))));
        customer1.addDrinkToOrder(new Cappuccino(Beverage.Size.LARGE, new BuyNGetOneFreeDiscount(customer1, 3)));
        //Makes beverages for customer1 (Fred).
        customer1.checkout();
    }
}

//sizes 'pricemod' was not applied (can be done so by adding to each specific beverages size).
//increments loyalty with each drink added to the collection