package com.pluralsight.delicious;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
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


    public Checkout(Order order, Customer customer) {
        this.price = order.calculatePrice();
        this.order = order;
        this.customer = customer;
        this.orderDateTime = order.getOrderDateTime();
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

    public void writeOrderToFile(Order order) {
        LocalDateTime orderDateTime = order.getOrderDateTime();
        DateTimeFormatter orderFormatter = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");

        String fileName = String.valueOf(orderDateTime.format(orderFormatter)) + ".txt";

        try{
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/main/receipts/" + fileName));

            StringBuilder stringBuilder = new StringBuilder();

            stringBuilder.append("Order for ").append(customer.getName()).append(" (ID: ").append(customer.getCustomerId()).append(")\n");

            DateTimeFormatter formatOrderDateTime = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm a");
            stringBuilder.append("Date/Time: ").append(orderDateTime.format(formatOrderDateTime)).append("\n\n");

            stringBuilder.append("Sandwiches:\n");
            for(Sandwich sandwich : sandwiches) {
                stringBuilder.append(sandwich.toString()).append("\n");
            }

            stringBuilder.append("\nChips:\n");
            for(Chips chips : chipList) {
                stringBuilder.append("\t").append(chips.getFlavor())
                             .append("   $").append(String.format("%.2f", chips.calculatePrice())).append("\n");
            }

            stringBuilder.append("\nDrinks:\n");
            for(Drink drink : drinks) {
                stringBuilder.append("\t").append(drink.getDrinkSize()).append(" ")
                             .append(drink.getFlavor()).append("   $")
                             .append(String.format("%.2f", drink.calculatePrice())).append("\n");
            }

            stringBuilder.append("\nTotal: $").append(String.format("%.2f", price)).append("\n");


            bufferedWriter.write(stringBuilder.toString());
            bufferedWriter.close();
        } catch (IOException e) {
            e.getStackTrace();
        }
    }


}
