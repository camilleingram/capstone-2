package com.pluralsight.delicious;

import java.util.ArrayList;
import java.util.List;

public class Chips implements Priceable{
    private String flavor = "";
    private double price = 0;
    private List<Chips> chipsList = new ArrayList<>();

    public Chips(String flavor) {
        this.flavor = flavor;
        this.price = price;
    }


    public String getFlavor() {
        return flavor;
    }

    public double getPrice() {
        return price;
    }

    public List<Chips> getChipsList() {
        return chipsList;
    }

    public void addChips(Chips chips) {
        chipsList.add(chips);
    }

    @Override
    public double calculatePrice() {
       if(flavor != null) {
           price += 1.50;
       }
       return price;
    }
}
