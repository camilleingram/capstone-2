package com.pluralsight.delicious;

import java.util.ArrayList;
import java.util.List;

public class Sandwich {
    private String bread = "";
    private List<Topping> toppings;
    private boolean isToasted;

    public Sandwich(String bread, List<Topping> toppings, boolean isToasted) {
        this.bread = bread;
        this.toppings = new ArrayList<>();
        this.isToasted = isToasted;
    }

    public String getBread() {
        return bread;
    }

    public List<Topping> getToppings() {
        return toppings;
    }
}
