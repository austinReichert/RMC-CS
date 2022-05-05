package com.company;

public class WhippedCream extends BeverageAddOn {

    public static final int PRICE = 75;

    public WhippedCream(Beverage b){
        super(b);
    }

    public int getPrice(){ return PRICE + beverage.getPrice(); }

    public String toString() { return beverage.toString() + " + Whipped Cream " + "($" + PRICE/100 + "." + PRICE%100 + ")"; }

}
