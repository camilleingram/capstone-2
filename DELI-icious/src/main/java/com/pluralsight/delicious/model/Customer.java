package com.pluralsight.delicious.model;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name = "";
    private int customerId = 1;
    private List<Order> previousOrders;

    public Customer(String name) {
        this.name = name;
        this.customerId = customerId++;
        this.previousOrders = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCustomerId() {
        return customerId;
    }

    public List<Order> getPreviousOrders() {
        return previousOrders;
    }

    public void addToPreviousOrders(Order order) {
        previousOrders.add(order);
    }
}
