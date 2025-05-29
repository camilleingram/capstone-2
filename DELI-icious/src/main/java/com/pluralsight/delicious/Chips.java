package com.pluralsight.delicious;

public class Chips implements Priceable{
    private String flavor = "";
    private double price = 0;

    public Chips(String flavor) {
        this.flavor = flavor;
        this.price = price;
    }

    public String getFlavor() {
        return flavor;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public double calculatePrice() {
        return price += 1.50;
    }
}
