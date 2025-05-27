package com.pluralsight.delicious;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Order {
    Scanner scanner = new Scanner(System.in);
    private int orderNumber = 1;
    private int total = 0;
    private List<Sandwich> sandwiches;
    private List<Drink> drinks;
    private List<Chips> chips;

    public Order(int orderNumber) {
        this.orderNumber = orderNumber;
        this.sandwiches = new ArrayList<>();
        this.drinks = new ArrayList<>();
        this.chips = new ArrayList<>();
    }

    public void displayMenu() {
        int order = addToOrder(scanner);

        switch(order) {
            case 1:
                Sandwich sandwich = new Sandwich();
                sandwich.setBread(askForBread(scanner));

                sandwiches.add(sandwich);
        }

    }

    public int addToOrder(Scanner scanner) {
        System.out.println("What would you like to add to your order? ");
        System.out.println("1. Add a sandwich\n 2. Add a drink\n 3. Add a bag of chips \n 4. Checkout please\n 5. I want to cancel my order");
        int order = scanner.nextInt();
        return order;
    }

    public int askForBread(Scanner scanner) {
        System.out.println("What kind of bread would you like?");
        System.out.println("1. White\n 2. Wheat\n 3. Rye\n 4. Wrap");
        int bread = scanner.nextInt();
        scanner.nextLine();
        return bread;
    }

}
