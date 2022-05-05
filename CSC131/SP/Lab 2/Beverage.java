package com.company;

public abstract class Beverage implements DiscountStrategy{

    public static final int SIZE_SMALL = 0;
    public static final int SIZE_MEDIUM = 1;
    public static final int SIZE_LARGE = 2;
    public DiscountStrategy discount;
    public int price;
    public int size;

    public Beverage(int price, int size, DiscountStrategy discount){
        this.price = price;
        this.size = size;
        this.discount = discount;
    }

    public int getPrice(){ return discount.getPrice(price); }
    //returns 'discounts' getPrice

    public abstract String toString();
    //Abstract means that it does not need '{}'

}

