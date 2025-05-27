package com.pluralsight.delicious;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name = "";
    private int orderNumber = 1;
    private List<Order> previousOrders;

    public Customer(String name) {
        this.name = name;
        this.orderNumber = orderNumber++;
        this.previousOrders = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public List<Order> getPreviousOrders() {
        return previousOrders;
    }

    public void addToPreviousOrders(Order order) {
        previousOrders.add(order);
    }
}
