package com.company;

public class Latte extends Beverage{

    public static final int BASE_PRICE = 400;

    public Latte(Size size, DiscountStrategy discount){
        super(size, discount);
        this.price = BASE_PRICE;
    }

    public String toString() { return size.toString() + " Latte " + "($" + getPrice()/100 + "." + getPrice()%100 + ")"; }
}
