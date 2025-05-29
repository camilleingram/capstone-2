package com.pluralsight.delicious;

import java.util.ArrayList;
import java.util.List;


public class Order implements Priceable {

    private int orderNumber = 1;
    private int total = 0;
    private List<Sandwich> sandwiches;
    private List<Drink> drinks;
    private List<Chips> chipList;

    public Order(int orderNumber) {
        this.orderNumber = orderNumber;
        this.sandwiches = new ArrayList<>();
        this.drinks = new ArrayList<>();
        this.chipList = new ArrayList<>();
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public int getTotal() {
        return total;
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

    @Override
    public double calculatePrice() {

    }
}
