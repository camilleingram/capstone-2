package com.pluralsight.delicious;

public abstract class Topping implements Priceable{
    private boolean isExtra;
    private int sandwichSize;
    private String toppingName;
    private double price = 0;

    public Topping(boolean isExtra, int sandwichSize, String toppingName) {
        this.isExtra = isExtra;
        this.sandwichSize = sandwichSize;
        this.toppingName = toppingName;
        this.price = price;
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

    public String getToppingName() {
        return toppingName;
    }

    @Override
    public abstract double calculatePrice();

}
