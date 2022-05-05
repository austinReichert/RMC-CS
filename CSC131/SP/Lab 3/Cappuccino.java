package com.company;

public class Cappuccino extends Beverage{

    public static final int BASE_PRICE = 300;

    public Cappuccino(Size size, DiscountStrategy discount){
        super(size,discount);
        this.price = BASE_PRICE;
    }

    public String toString() {
        return size.toString() + " Cappuccino " + "($" + getPrice()/100 + "." + getPrice()%100 + ")";
    }

}