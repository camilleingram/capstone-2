package com.pluralsight.delicious;

import java.util.ArrayList;
import java.util.List;

public class Sandwich implements Priceable{
    private Bread bread;
    private List<Topping> toppings;
    private List<Topping> sauces;
    private boolean isToasted;
    private int sandwichSize = 0;
    private double price = 0;

    public Sandwich(Bread bread, List<Topping> toppings, List<Topping> sauces, boolean isToasted, int sandwichSize) {
        this.bread = bread;
        this.toppings = toppings;
        this.sauces = sauces;
        this.isToasted = isToasted;
        this.sandwichSize = sandwichSize;
        this.price = price;
    }

    public Bread getBread() {
        return bread;
    }

    public List<Topping> getToppings() {
        return toppings;
    }

    public List<Topping> getSauces() {
        return sauces;
    }

    public boolean isToasted() {
        return isToasted;
    }

    public int getSandwichSize() {
        return sandwichSize;
    }

    @Override
    public double calculatePrice() {
        price += bread.calculatePrice();
        for(Topping topping : toppings) {
            if(topping instanceof Meat meat) {
                price += meat.calculatePrice();
            }else if(topping instanceof Cheese cheese) {
                price += cheese.calculatePrice();
            }
        }
        return price;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(String.format("\tSize: %d-inch ($%.2f)\n", sandwichSize, bread.getPrice()));
        stringBuilder.append(String.format("\tBread: %s\n", bread.getBreadType()));

        stringBuilder.append("\tToppings\n");

        for (Topping topping : toppings) {
            if (topping instanceof Meat meat) {
                if (meat.isExtra()) {
                    stringBuilder.append(String.format("\t\tExtra %s ($%.2f)\n", meat.getToppingName(), meat.calculatePrice()));
                } else {
                    stringBuilder.append(String.format("\t\t%s ($%.2f)\n", meat.getToppingName(), meat.calculatePrice()));
                }
            } else if (topping instanceof Cheese cheese) {
                if (cheese.isExtra()) {
                    stringBuilder.append(String.format("\t\tExtra %s ($%.2f)\n", cheese.getToppingName(),
                                                       cheese.calculatePrice()));
                } else {
                    stringBuilder.append(String.format("\t\t%s ($%.2f)\n", cheese.getToppingName(), cheese.calculatePrice()));
                }
            } else if (topping instanceof RegularTopping regTopping) {
                if (regTopping.isExtra()) {
                    stringBuilder.append(String.format("\t\tExtra %s ($%.2f)\n", regTopping.getToppingName(), regTopping.calculatePrice()));
                } else {
                    stringBuilder.append(String.format("\t\t%s ($%.2f)\n", regTopping.getToppingName(), regTopping.calculatePrice()));
                }
            }
        }

        stringBuilder.append("\tSauce\n");
        for (Topping sauce : sauces) {

            if (sauce.isExtra()) {
                stringBuilder.append(String.format("\t\tExtra %s ($%.2f)\n", sauce.getToppingName(), sauce.calculatePrice()));
            } else {
                stringBuilder.append(String.format("\t\t%s ($%.2f)\n", sauce.getToppingName(), sauce.calculatePrice()));
            }
        }

        return stringBuilder.toString();
    }

    public static class Builder {
        private Bread bread;
        private List<Topping> toppings = new ArrayList<>();
        private List<Topping> sauces = new ArrayList<>();
        private boolean isToasted;
        private int sandwichSize = 0;

        public void setBread(Bread bread) {
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

        public void removeTopping(Topping topping) {
            this.toppings.remove(topping);
        }

        public List<Topping> getToppings() {
            return toppings;
        }

        public List<Topping> getSauces() {
            return sauces;
        }

        public Sandwich build() {
            return new Sandwich(bread, toppings, sauces, isToasted, sandwichSize);
        }
    }

}
