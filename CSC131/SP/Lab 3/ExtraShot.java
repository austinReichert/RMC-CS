package com.company;

public class ExtraShot extends BeverageAddOn {

    public static final int PRICE = 50;

    public ExtraShot(Beverage b){
        super(b);
    }

    public int getPrice(){ return PRICE + beverage.getPrice(); }

    public String toString() { return beverage.toString() + " + Extra Shot " + "($" + PRICE/100 + "." + PRICE%100 + ")"; }


}
