package com.pluralsight.delicious;

import java.util.Scanner;

import static com.pluralsight.delicious.App.scanner;

public class OrderScreen {
    private String[] drinks = {"Sprite", "Dr. Pepper", "Mt. Dew", "Orange Fanta", "Lemonade", "Hi-C", "Water"};
    private String[] chipList = {"BBQ", "Salt & Vinegar", "Sour Cream & Cheddar", "Flamin' Hot Cheetos", "Nacho Cheese Doritos", "Lay's Potato Chips"};

    public void displayOrderScreen() {
        int orderType = addToOrder(scanner);
        int order = addToOrder(scanner);

        switch(order) {
            case 1:
                AddSandwichScreen sandwichScreen = new AddSandwichScreen();
                sandwichScreen.displayAndBuildSandwich();
                order = addToOrder(scanner);
                break;
            case 2:

        }


    }

    public int askForDrink(Scanner scanner) {
        System.out.println("Would you like a drink? ");
        String wantDrink = scanner.nextLine();

        if(wantDrink.equalsIgnoreCase("Yes")) {


            while(true) {
                System.out.println("What size drink would you like?");
                System.out.println("1. Small\n" +
                                   "2.Medium\n" +
                                   "3.Large\n" +
                                   "0. Move onto chips");
                int drinkSize = scanner.nextInt();
                scanner.nextLine();

                if(drinkSize == 0) {
                    System.out.println("Ok, let's move onto chips!");
                    break;
                }

                System.out.println("What flavor would you like? ");
                int drinkCounter = 1;
                for(String drink : drinks) {
                    System.out.printf("%d. %s%n", drinkCounter++, drink);
                }
                int drinkIndex = scanner.nextInt();
                scanner.nextLine();

                String drinkFlavor = drinks[drinkIndex -1];
                System.out.printf("You asked for a %s %s", dr);
            }
        }





    }

    public int addToOrder(Scanner scanner) {
        System.out.println("What would you like to add to your order? ");
        System.out.println("1. Add a sandwich\n2. Add a drink\n3. Add a bag of chips \n4. Checkout please\n5. I want to cancel my order");
        int order = scanner.nextInt();
        return order;
    }


}
