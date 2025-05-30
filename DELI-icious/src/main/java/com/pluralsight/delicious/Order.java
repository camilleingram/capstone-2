package com.pluralsight.delicious;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class Order implements Priceable {

    private int orderNumber = 1;
    private double total = 0;
    private List<Sandwich> sandwiches;
    private List<Drink> drinks;
    private List<Chips> chipList;
    private LocalDateTime orderDateTime;

    public Order() {
        this.orderNumber = orderNumber++;
        this.sandwiches = new ArrayList<>();
        this.drinks = new ArrayList<>();
        this.chipList = new ArrayList<>();
        this.total = total;
        this.orderDateTime = LocalDateTime.now();
    }

    public int getOrderNumber() {
        return orderNumber;
    }


    public List<Sandwich> getSandwiches() {
        return sandwiches;
    }

    public List<Drink> getDrinks() {
        return drinks;
    }

    public List<Chips> getChipList() {
        return chipList;
    }

    public void addSandwich(Sandwich sandwich) {
        sandwiches.add(sandwich);
    }

    public void addDrink(Drink drink) {
        drinks.add(drink);
    }

    public void addChips(Chips chips) {
        chipList.add(chips);
    }

    public LocalDateTime getOrderDateTime() {
        return orderDateTime;
    }



    @Override
    public double calculatePrice() {
       for (Sandwich sandwich : sandwiches) {
           total += sandwich.calculatePrice();
       }
       for(Chips chips : chipList) {
           total += chips.calculatePrice();
       }
       for(Drink drink : drinks) {
           total += drink.calculatePrice();
       }
        return total;
    }


}
