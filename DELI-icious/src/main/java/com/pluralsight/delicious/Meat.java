package com.pluralsight.delicious;

import java.util.ArrayList;
import java.util.List;

public class Meat extends PremiumTopping{

    private String meatType = "";
    private List<Meat> meats = new ArrayList<>();

    public Meat(boolean isExtra, int sandwichSize, String meatType) {
        super(isExtra, sandwichSize);
        this.meatType = meatType;
    }

    public String getMeatType() {
        return meatType;
    }


    public List<Meat> getMeats() {
        return meats;
    }

    public void addMeat(Meat meat) {
        meats.add(meat);
    }

    @Override
    public double calculatePrice() {
        double total = 0;
        for(Meat meat : meats) {
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
