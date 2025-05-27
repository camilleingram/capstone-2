package com.pluralsight.delicious;

public class Bread {
    private String breadType = "";
    private double price = 0;
    private int sandwichSize = 0;


    public Bread(String breadType, int sandwichSize) {
        this.breadType = breadType;
        this.price = price;
        this.sandwichSize = sandwichSize;
    }

    public String getBreadType() {
        return breadType;
    }

    public int getSandwichSize() {
        return sandwichSize;
    }

    public double getPrice() {
        switch(sandwichSize) {
            case 4:
                price = 5.50;
                break;
            case 8:
                price = 7.00;
                break;
            case 12:
                price = 8.50;
        }
        return price;
    }
}
