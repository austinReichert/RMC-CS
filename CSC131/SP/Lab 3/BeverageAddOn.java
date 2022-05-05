package com.company;

public abstract class BeverageAddOn extends Beverage{

    public Beverage beverage;

    public BeverageAddOn(Beverage beverage) {
        super(beverage.getSize(), beverage.getDiscountStrategy());
        this.beverage = beverage;
    }
}
