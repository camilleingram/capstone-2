package com.pluralsight.delicious;

import java.util.ArrayList;
import java.util.List;

public abstract class PremiumTopping implements Topping{
    private boolean isExtra;
    private int sandwichSize;

    public PremiumTopping(boolean isExtra, int sandwichSize) {
        this.isExtra = isExtra;
        this.sandwichSize = sandwichSize;
    }

    public boolean isExtra() {
        return isExtra;
    }

    public void setExtra(boolean extra) {
        isExtra = extra;
    }

    public int getSandwichSize() {
        return sandwichSize;
    }

    @Override
    public abstract double calculatePrice();

}
