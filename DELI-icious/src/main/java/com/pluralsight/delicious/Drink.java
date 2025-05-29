package com.pluralsight.delicious;

import java.util.ArrayList;
import java.util.List;

public class Drink implements Priceable{
    private String drinkSize = "";
    private String flavor = "";
    private double price = 0;
    private List<Drink> drinks = new ArrayList<>();

    public Drink(String drinkSize, String flavor) {
        this.drinkSize = drinkSize;
        this.flavor = flavor;
    }

    public String getDrinkSize() {
        return drinkSize;
    }

    public String getFlavor() {
        return flavor;
    }

    public List<Drink> getDrinks() {
        return drinks;
    }

    public void addDrinks(Drink drink) {
        drinks.add(drink);
    }

    @Override
    public double calculatePrice() {

        switch(drinkSize) {
            case "Small":
                price += 2.00;
                break;
            case "Medium":
                price += 2.50;
                break;
            case "Large":
                price += 3.00;
                break;
        }
        return price;
    }
}

