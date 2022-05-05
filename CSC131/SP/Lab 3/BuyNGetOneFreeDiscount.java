package com.company;

public class BuyNGetOneFreeDiscount implements DiscountStrategy{

    public int targetLoyalty;
    public Customer customer;

    public BuyNGetOneFreeDiscount(Customer customer, int targetLoyalty) {
        this.customer = customer;
        this.targetLoyalty = targetLoyalty;
    }

    public int getDiscountPrice(Beverage b) {
        if((b.getBeveragePrice() > 0) && (customer.getLoyalty() >= targetLoyalty)){
            customer.setLoyalty(customer.getLoyalty() - targetLoyalty);
            b.setPrice(0);
        }
        return b.getBeveragePrice();
    }

}
