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
        this.toppings = toppings;
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
        private List<Topping> toppings;
        private boolean isToasted;
        private int sandwichSize = 0;

        public Builder setBread(String bread) {
            this.bread = bread;
            return this;
        }

        public Builder setToppings(List<Topping> toppings) {
            this.toppings = toppings;
            return this;
        }

        public Builder setToasted(boolean toasted) {
            isToasted = toasted;
            return this;
        }

        public Builder setSandwichSize(int sandwichSize) {
            this.sandwichSize = sandwichSize;
            return this;
        }

        public Builder addTopping(Topping topping) {
            this.toppings.add(topping);
            return this;
        }

        public Sandwich build() {
            return new Sandwich(bread, toppings, isToasted, sandwichSize);
        }
    }


}
