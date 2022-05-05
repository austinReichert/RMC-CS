package com.company;

public abstract class Beverage {

    public enum Size {
        SMALL("Small", 80),
        MEDIUM("Medium", 100),
        LARGE("Large", 120);

        private String description;
        private int priceMod;

        Size(String description, int priceMod) {
            this.description = description;
            this.priceMod = priceMod;
        }

        public int getPriceMod() { return priceMod; }

        public String toString() {
            return this.description;
        }
    }

    public DiscountStrategy discount;
    public Size size;
    int price;

    public Beverage(Size size, DiscountStrategy discount){
        this.size = size;
        this.discount = discount;
    }

    public int getPrice(){ return discount.getDiscountPrice(this); }
    //returns 'discounts' getPrice

    public void setPrice(int price){
        this.price = price; }

    public abstract String toString();
    //Abstract means that it does not need '{}'

    public DiscountStrategy getDiscountStrategy() {
        return discount;
    }

    public Size getSize(){ return size; }

    public int getBeveragePrice(){
        return price;
    }
    //Gets price before discounts
}

