package com.pluralsight.delicious;

import java.util.ArrayList;
import java.util.List;

public class Sandwich {
    private String bread = "";
    private List<Topping> toppings;
    private boolean isToasted;
    private int sandwichSize = 0;

    public Sandwich(String bread, List<Topping> toppings, boolean isToasted, int sandwichSize) {
        this.bread = bread;
        this.toppings = new ArrayList<>();
        this.isToasted = isToasted;
        this.sandwichSize = sandwichSize;
    }

    public String getBread() {
        return bread;
    }

    public List<Topping> getToppings() {
        return toppings;
    }


    public static class Builder {
        private String bread = "";
        private List<Topping> toppings = new ArrayList<>();
        private List<Topping> sauces = new ArrayList<>();
        private boolean isToasted;
        private int sandwichSize = 0;

        public void setBread(String bread) {
            this.bread = bread;
        }

        public void setToasted(boolean toasted) {
            isToasted = toasted;
        }


        public void setSandwichSize(int sandwichSize) {
            this.sandwichSize = sandwichSize;
        }

        public void addSauce(Topping sauce) {
            this.sauces.add(sauce);
        }

        public void addTopping(Topping topping) {
            this.toppings.add(topping);
        }

        public Sandwich build() {
            return new Sandwich(bread, toppings, isToasted, sandwichSize);
        }
    }


}
