package com.company;

public class NoDiscount implements DiscountStrategy{

    public int getPrice(int price) {
        return price;
    }

}
