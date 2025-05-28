package com.pluralsight.delicious;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.pluralsight.delicious.App.scanner;

public class AddSandwichScreen {
    private Sandwich sandwich = null;
    private String[] breadTypes = {"White", "Wheat", "Rye", "Wrap"};
    private String[] meatTypes = {"Steak", "Ham", "Salami", "Roast Beef", "Chicken", "Chicken"};
    private String[] cheeseTypes = {"American", "Provolone", "Cheddar", "Swiss"};
    private String[] regularToppings = {"Lettuce", "Peppers", "Onions", "Tomatoes", "Jalapeños", "Cucumbers", "Pickles", "Guacamole", "Mushrooms"};
    private double price = 0;
    private List<Topping> toppings = new ArrayList<>();

    public void displaySandwichScreen() {
        int breadIndex = askForBread(scanner);
        String breadChoice = breadTypes[breadIndex];
        System.out.printf("You have selected %s bread%n", breadChoice);

        int sandwichSize = askForSize(scanner);
        System.out.printf("You have selected the %d-inch sandwich", sandwichSize);



    }

    public Meat askForMeat(Scanner scanner) {
        System.out.println("What meat would you like? ");
        int toppingCounter = 1;
        for(String meat : meatTypes) {
            System.out.printf("%d. %s%n", toppingCounter++, meat);
        }
        System.out.println("0. I don't want any meat");

        int meatChoice = scanner.nextInt();
        scanner.nextLine();

        System.out.printf("Would you like extra %s", meatTypes[meatChoice - 1]);
        String extraMeat = scanner.nextLine();

        if(extraMeat.equalsIgnoreCase("Yes")) {
            Meat meat = new Meat()
        }

    }

    public int askForSize(Scanner scanner) {
        System.out.println("What size sandwich would you like?");
        System.out.println("(4) 4-inch Sandwich Starts at $5.50\n(8) 8-inch sandwich Starts at $7.00\n(12) 12-inch sandwich " + "Starts at 8.50");
        int sandwichSize = scanner.nextInt();
        scanner.nextLine();

        return sandwichSize;
    }


    public int askForBread(Scanner scanner) {
        System.out.println("What kind of bread would you like?");
        System.out.println("1. White\n 2. Wheat\n 3. Rye\n 4. Wrap");
        int bread = scanner.nextInt();
        scanner.nextLine();

        return bread;
    }


}
