package com.pluralsight.delicious;

import java.util.ArrayList;
import java.util.List;

public class Drink implements Priceable{
    private int drinkSize = 0;
    private String flavor = "";
    private double price = 0;
    private List<Drink> drinks = new ArrayList<>();

    public Drink(int drinkSize, String flavor) {
        this.drinkSize = drinkSize;
        this.flavor = flavor;
    }

    public int getDrinkSize() {
        return drinkSize;
    }

    public String getFlavor() {
        return flavor;
    }

    public List<Drink> getDrinks() {
        return drinks;
    }

    @Override
    public double calculatePrice() {

        switch(drinkSize) {
            case 1:
                price += 2.00;
                break;
            case 2:
                price += 2.50;
                break;
            case 3:
                price += 3.00;
                break;
        }
        return price;
    }
}

