package com.company;

import java.util.ArrayList;

public class Customer {

    private int Loyalty;
    private ArrayList<Beverage> currentDrinkOrder;
    private String name;

    public Customer(String name){
        this.Loyalty = Loyalty;
        this.name = name;
        this.currentDrinkOrder = new ArrayList<>();
    }

    public void addDrinkToOrder(Beverage beverage){
        currentDrinkOrder.add(beverage);
    }

    public int calculateBill(){
        int bill = 0;

        for(Beverage b : currentDrinkOrder){
        bill = bill + b.getPrice();
        //System.out.println(bill); //this shows 'decimals' (toString/checkout doesn't)
        }
        //goes through customers order and grabs every price. adds it.

        return bill;
    }

    public int getLoyalty() {
        return Loyalty;
    }

    public void incrementLoyalty(){
        Loyalty++;
    }

    public void checkout(){
        System.out.println(name + ", your order is: ");
        System.out.println("");

        for(Beverage b : currentDrinkOrder){
            System.out.println(b.toString()); }
        //prints all of the drinks and their prices.

        int total = calculateBill();
        System.out.println("\n" + name +"'s total is: $" + total/100 + "." + total%100);
        //prints their total

        currentDrinkOrder.clear();
        //Clears the current order. (Customer 'pays' for the current order).
        System.out.println("________________________________________________________________________________");
        //Makes the console less gross to look at.
    }
}