package com.company;

public class HappyHourDiscount implements DiscountStrategy {

    public int discountRate = 0;
    //Sets the default discountRate at 0.

    public HappyHourDiscount(int discountRate){
        this.discountRate = discountRate;
    }
    //Takes in an input as a discountRate.

    public int getDiscountPrice(Beverage b) { return b.getBeveragePrice()*(100-discountRate)/100;
    }

}