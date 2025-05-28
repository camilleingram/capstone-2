package com.pluralsight.delicious;

import java.util.ArrayList;
import java.util.List;

public class Sauce extends RegularTopping{

    private List<Topping> sauces = new ArrayList<>();

    public Sauce(boolean isExtra, String toppingType, int sandwichSize) {
        super(isExtra, toppingType, sandwichSize);
    }

    public List<Topping> getSauce() {
        return sauces;
    }

    @Override
    public void addTopping(Topping sauce) {
        sauces.add(sauce);
    }
}
