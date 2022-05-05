package com.company;

public class Mocha extends Latte{

    public static final int BASE_PRICE = 500;

    public Mocha(Size size, DiscountStrategy discount){
        super(size, discount);
        this.price = BASE_PRICE;
    }

    public String toString() { return size.toString() + " Mocha " + "($" + getPrice()/100 + "." + getPrice()%100 + ")"; }

}
