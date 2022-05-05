package com.company;

public class ExtraFroth extends BeverageAddOn {

    public static final int PRICE = 85;

    public ExtraFroth(Beverage b){
        super(b);
    }

    public int getPrice(){ return PRICE + beverage.getPrice(); }

    public String toString() {
        return beverage.toString() + " + Extra Froth " + "($" + PRICE/100 + "." + PRICE%100 + ")";
    }


}
