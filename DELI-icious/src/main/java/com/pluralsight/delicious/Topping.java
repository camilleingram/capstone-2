package com.pluralsight.delicious;

import java.util.List;

public abstract class Topping {
    private int sandwichSize = 0;
    private double price = 0;
    private boolean isExtra = false;

    public Topping(int sandwichSize, boolean isExtra) {
        this.sandwichSize = sandwichSize;
        this.isExtra = isExtra;
    }

    public int getSandwichSize() {
        return sandwichSize;
    }

    public double getPrice() {
        return price;
    }

    public boolean isExtra() {
        return isExtra;
    }

    public double calculatePrice(Topping topping) {



        return price;
    }

}
