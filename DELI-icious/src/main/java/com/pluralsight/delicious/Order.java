package com.pluralsight.delicious;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Order {
    Scanner scanner = new Scanner(System.in);
    private int orderNumber = 1;
    private int total = 0;
    private List<Sandwich> sandwiches;
//    private List<Drink> drinks;
//    private List<Chips> chips;

    public Order(int orderNumber) {
        this.orderNumber = orderNumber;
        this.sandwiches = new ArrayList<>();
//        this.drinks = new ArrayList<>();
//        this.chips = new ArrayList<>();
    }

    public Order() {

    }

    public void displayMenu() {
        int order = addToOrder(scanner);

        switch(order) {
            case 1:
            AddSandwichScreen sandwichScreen = new AddSandwichScreen();
            sandwichScreen.displaySandwichScreen();
            Sandwich addedSandwich =

        }

    }

    public int addToOrder(Scanner scanner) {
        System.out.println("What would you like to add to your order? ");
        System.out.println("1. Add a sandwich\n2. Add a drink\n3. Add a bag of chips \n4. Checkout please\n5. I want to cancel my order");
        int order = scanner.nextInt();
        return order;
    }



}
