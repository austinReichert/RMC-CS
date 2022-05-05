package com.company;

public class BeverageMain{
    public static void main(String[] args){

        Customer customer1 = new Customer("Carl");
        Customer customer2 = new Customer("Frank");
        Customer customer3 = new Customer("Jeff");
        //Makes new customers.

        customer1.addDrinkToOrder(new Latte(200,Beverage.SIZE_SMALL, new HappyHourDiscount(25)));
        customer1.addDrinkToOrder(new Mocha(500,Beverage.SIZE_LARGE, new NoDiscount()));
        customer1.addDrinkToOrder(new Cappuccino(400,Beverage.SIZE_MEDIUM, new NoDiscount()));
        customer1.addDrinkToOrder(new Latte(200,Beverage.SIZE_SMALL, new BuyNGetOneFreeDiscount(customer1,2)));
        customer1.addDrinkToOrder(new Mocha(200,Beverage.SIZE_SMALL, new BuyNGetOneFreeDiscount(customer1,2)));
        customer1.addDrinkToOrder(new Cappuccino(400,Beverage.SIZE_MEDIUM, new NoDiscount()));
            //Makes beverages for customer1 (Carl).
        customer1.checkout();

        customer2.addDrinkToOrder(new Latte(400,Beverage.SIZE_MEDIUM, new NoDiscount()));
        customer2.addDrinkToOrder(new Mocha(200,Beverage.SIZE_SMALL, new HappyHourDiscount(25)));
        customer2.addDrinkToOrder(new Cappuccino(500,Beverage.SIZE_LARGE, new BuyNGetOneFreeDiscount(customer2,3)));
        customer2.addDrinkToOrder(new Latte(200,Beverage.SIZE_SMALL,new BuyNGetOneFreeDiscount(customer2,3)));
        customer2.addDrinkToOrder(new Cappuccino(400,Beverage.SIZE_MEDIUM,new BuyNGetOneFreeDiscount(customer2,3)));
        customer2.addDrinkToOrder(new Latte(500,Beverage.SIZE_LARGE, new NoDiscount()));
        customer2.addDrinkToOrder(new Mocha(400,Beverage.SIZE_MEDIUM, new HappyHourDiscount(25)));
        customer2.addDrinkToOrder(new Mocha(500,Beverage.SIZE_LARGE, new NoDiscount()));
            //Makes beverages for customer2 (Frank)
        customer2.checkout();

        customer3.addDrinkToOrder(new Mocha(1500,Beverage.SIZE_LARGE, new HappyHourDiscount(45)));
        customer3.addDrinkToOrder(new Cappuccino(1400,Beverage.SIZE_MEDIUM, new HappyHourDiscount(25)));
        customer3.addDrinkToOrder(new Latte(1000,Beverage.SIZE_MEDIUM, new HappyHourDiscount(5)));
            //Makes beverages for customer3 (Jeff)
        customer3.checkout();

    }
}