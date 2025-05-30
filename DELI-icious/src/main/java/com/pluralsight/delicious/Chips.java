package com.pluralsight.delicious;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public double calculatePrice() {
       return price = 1.50;
    }
}
