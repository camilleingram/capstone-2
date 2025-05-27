package com.pluralsight.delicious;

import java.util.ArrayList;
import java.util.List;

public class Cheese extends Topping{

    private String cheeseType = "";
    private List<Cheese> cheeses = new ArrayList<>();

    public Cheese(int sandwichSize, boolean isExtra, String cheeseType) {
        super(sandwichSize, isExtra);
        this.cheeseType = cheeseType;
    }

    public double calculateCheese() {
        double total = 0;
        for(Cheese cheese: cheeses) {
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
