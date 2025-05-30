package com.pluralsight.delicious.model;

public class RegularTopping extends Topping {


    public RegularTopping(boolean isExtra, int sandwichSize, String toppingName) {
        super(isExtra, sandwichSize, toppingName);
    }

    @Override
    public double calculatePrice() {
        return 0.0;
    }

}
