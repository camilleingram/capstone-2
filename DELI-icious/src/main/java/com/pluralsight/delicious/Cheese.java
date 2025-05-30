package com.pluralsight.delicious;

public class Cheese extends Topping {
    private double price = 0;

    public Cheese(boolean isExtra, int sandwichSize, String toppingName) {
        super(isExtra, sandwichSize, toppingName);
    }

    @Override
    public double calculatePrice() {
        switch(super.getSandwichSize()) {
            case 4:
                price = 0.75;
                if(isExtra()) {
                    price += 0.30;
                }
                break;
            case 8:
                price = 1.50;
                if(isExtra()) {
                    price += 0.60;
                }
                break;
            case 12:
                price = 2.25;
                if(isExtra()) {
                    price += 0.90;
                }
                break;
        }
        return price;
    }
}
