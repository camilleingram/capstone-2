package com.pluralsight.delicious;

import java.util.ArrayList;
import java.util.List;

public class RegularTopping implements Topping{
    private boolean isExtra = false;
    private String toppingType = "";
    private int sandwichSize = 0;
    private List<Topping> regularToppings = new ArrayList<>();

    public RegularTopping(boolean isExtra, String toppingType, int sandwichSize) {
        this.isExtra = isExtra;
        this.toppingType = toppingType;
        this.sandwichSize = sandwichSize;
    }

    public boolean isExtra() {
        return isExtra;
    }

    public void setExtra(boolean extra) {
        isExtra = extra;
    }

    public String getToppingType() {
        return toppingType;
    }

    public List<Topping> getRegularToppings() {
        return regularToppings;
    }

    @Override
    public void addTopping(Topping topping) {
        regularToppings.add(topping);
    }

}
