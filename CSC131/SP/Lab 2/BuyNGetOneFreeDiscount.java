package com.company;

public class BuyNGetOneFreeDiscount implements DiscountStrategy{

    public int targetLoyalty;
    public Customer customer;
    public int currentLoyalty;

    public BuyNGetOneFreeDiscount(Customer customer, int targetLoyalty) {
        this.customer = customer;
        this.targetLoyalty = targetLoyalty;
        customer.incrementLoyalty();
        this.currentLoyalty = customer.getLoyalty();
    }

    public int getPrice(int price) {
        if(currentLoyalty%targetLoyalty==0){
            price = 0; }
        //If the current loyalty is divisible by the targetLoyalty then the drink is free. If not, doesn't do anything.

        return price;
    }

}
