package com.company;

public class Mocha extends Latte{

    public Mocha(int price, int size, DiscountStrategy discount){
        super(price, size, discount);
    }

    public String toString() {
        String s = "";
        if(size == 0){ s = "Small";}
        else if(size == 1){ s = "Medium";}
        else if(size == 2){ s = "Large";}
        //'s' is so the string changes depending on set size.

        int cost = discount.getPrice(price);

        return s + " Mocha. " + "$" + cost/100 + "." + cost%100;
    }

    public int getPrice(int price) {
        return discount.getPrice(price);
    }

}
