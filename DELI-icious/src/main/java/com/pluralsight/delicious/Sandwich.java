package com.pluralsight.delicious;

import java.util.ArrayList;
import java.util.List;

public class Sandwich {
    private Bread bread = null;
    private List<Topping> toppings;
    private boolean isToasted;

    public Sandwich(Bread bread, List<Topping> toppings, boolean isToasted) {
        this.bread = bread;
        this.toppings = new ArrayList<>();
        this.isToasted = isToasted;
    }


    public Bread getBread() {
        return bread;
    }

    public List<Topping> getToppings() {
        return toppings;
    }
}
