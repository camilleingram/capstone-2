package com.pluralsight.delicious;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Checkout {
    private double price = 0;
    private Order order;
    private Customer customer;
    private LocalDate orderDate = LocalDate.now();
    private LocalTime orderTime = LocalTime.now();
    private List<Sandwich> sandwiches;
    private List<Drink> drinks;
    private List<Chips> chipList;


    public Checkout(Order order, Customer customer, LocalDate orderDate, LocalTime orderTime) {
        this.price = order.calculatePrice();
        this.order = order;
        this.customer = customer;
        this.orderDate = orderDate;
        this.orderTime = orderTime;
        this.sandwiches = order.getSandwiches();
        this.drinks = order.getDrinks();
        this.chipList = order.getChipList();

    }

    public void displayOrderDetails() {
        System.out.printf("Order for %s (ID: %d)", customer.getName(),customer.getCustomerId());
        DateTimeFormatter orderDateTime = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        System.out.println();

    }
}
