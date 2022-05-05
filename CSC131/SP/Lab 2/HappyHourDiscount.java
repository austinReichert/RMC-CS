package com.company;

public class HappyHourDiscount implements DiscountStrategy {

    public int discountRate = 0;
    //Sets the default discountRate at 0.

    public HappyHourDiscount(int discountRate){
        this.discountRate = discountRate;
    }
    //Takes in an input as a discountRate.

    public int getPrice(int price) {
    return (price*(100-discountRate))/100;
    }
    //Takes the discountRate and subtracts it by 100, and divides it by 100.
    //Example: (100-25) -> 75/100 -> .75

}