package com.company;

public class NoDiscount implements DiscountStrategy{

    public int getDiscountPrice(Beverage b) {
        return b.getBeveragePrice();
    }

}
