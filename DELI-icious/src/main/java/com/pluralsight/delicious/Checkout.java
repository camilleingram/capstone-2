package com.pluralsight.delicious;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Checkout {
    private double price;
    private Order order;
    private Customer customer;
    private LocalDateTime orderDateTime;
    private List<Sandwich> sandwiches;
    private List<Drink> drinks;
    private List<Chips> chipList;


    public Checkout(Order order, Customer customer, LocalDateTime orderDateTime) {
        this.price = order.calculatePrice();
        this.order = order;
        this.customer = customer;
        this.orderDateTime = LocalDateTime.now();
        this.sandwiches = order.getSandwiches();
        this.drinks = order.getDrinks();
        this.chipList = order.getChipList();

    }

    public void displayOrderDetails() {
        System.out.printf("Order for %s (ID: %d)%n", customer.getName(),customer.getCustomerId());
        DateTimeFormatter formatOrderDateTime = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm a");
        this.orderDateTime.format(formatOrderDateTime);
//

        System.out.printf("Date/Time:  %tY-%tm-%td %tH:%tM %Tp%n",orderDateTime, orderDateTime, orderDateTime, orderDateTime, orderDateTime, orderDateTime);

        System.out.println("Sandwich");
        for(Sandwich sandwich : sandwiches) {
            System.out.print(sandwich.toString());
        }

        System.out.println("Chips");
        for(Chips chips : chipList) {
            System.out.printf("\t %s   $%.2f%n", chips.getFlavor(), chips.calculatePrice());
        }

        System.out.println("Drink");
        for(Drink drink : drinks) {
            System.out.printf("\t %s %s   $%.2f%n", drink.getDrinkSize(), drink.getFlavor(), drink.calculatePrice());
        }


        System.out.printf("Total       $%.2f%n", price);

    }


}
