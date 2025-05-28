package com.pluralsight.delicious;

import java.util.ArrayList;
import java.util.List;

public class Cheese extends PremiumTopping{

    private String cheeseType = "";
    private List<Topping> cheeses = new ArrayList<>();

    public Cheese(boolean isExtra, int sandwichSize, String cheeseType) {
        super(isExtra, sandwichSize);
        this.cheeseType = cheeseType;
    }

    public String getCheeseType() {
        return cheeseType;
    }

    public List<Topping> getCheeses() {
        return cheeses;
    }

    @Override
    public void addTopping(Topping cheese) {
        cheeses.add((Topping) cheese);
    }

    @Override
    public double calculatePrice() {
        double total = 0;
        for(Topping cheese: cheeses) {
            switch(super.getSandwichSize()) {
                case 4:
                    if(isExtra()) {
                        total += 0.50;
                    }
                    total += 1;
                    break;
                case 8:
                    if(isExtra()) {
                        total += 1;
                    }
                    total += 2;
                case 12:
                    if(isExtra()) {
                        total += 1.50;
                    }
                    total += 3;
            }
        }
        return total;
    }
}
