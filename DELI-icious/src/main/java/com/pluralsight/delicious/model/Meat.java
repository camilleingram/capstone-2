package com.pluralsight.delicious.model;

public class Meat extends Topping {

    private double price = 0;

    public Meat(boolean isExtra, int sandwichSize, String toppingName) {
        super(isExtra, sandwichSize, toppingName);
        this.price = price;
    }

    @Override
    public double calculatePrice() {
        switch(super.getSandwichSize()) {
            case 4:
                price = 1;
                if(isExtra()) {
                    price += 0.50;
                }
                break;
            case 8:
                price = 2;
                if(isExtra()) {
                    price += 1;
                }
                break;
            case 12:
                price = 3;
                if(isExtra()) {
                    price += 1.50;
                }
                break;
        }
        return price;
    }
}
