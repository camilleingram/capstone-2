package com.pluralsight.delicious;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

import static com.pluralsight.delicious.App.scanner;

public class OrderScreen {
    private String[] drinkSizes = {"Small", "Medium", "Large"};
    private String[] drinkFlavors = {"Sprite", "Dr. Pepper", "Mt. Dew", "Orange Fanta", "Lemonade", "Hi-C", "Water"};
    private String[] chipList = {"BBQ", "Salt & Vinegar", "Sour Cream & Cheddar", "Flamin' Hot Cheetos", "Nacho Cheese Doritos", "Lay's Potato Chips"};


    public void displayOrderScreen() {
        String customerName = askForName(scanner);
        Customer customer = new Customer(customerName);
        System.out.printf("Welcome, %s!", customer.getName());
        int orderType = addToOrder(scanner);
        Order order = new Order();

        switch(orderType) {
            case 1:
                AddSandwichScreen sandwichScreen = new AddSandwichScreen();
                Sandwich addedSandwich = sandwichScreen.displayAndBuildSandwich();
                order.addSandwich(addedSandwich);
                orderType = addToOrder(scanner);
                System.out.println(addedSandwich);
                break;
            case 2:
                Drink addedDrink = askForDrink(scanner);
                order.addDrink(addedDrink);
                orderType = addToOrder(scanner);
                break;
            case 3:
                Chips addedChips = askForChips(scanner);
                order.addChips(addedChips);
                orderType = addToOrder(scanner);
                break;
            case 4:
            Checkout checkout = new Checkout(order, customer, LocalDate.now(), LocalTime.now());
            checkout.displayOrderDetails();
            break;
        }


    }

    public Chips askForChips(Scanner scanner) {
        System.out.println("Would you like some chips? ");
        String wantChips = scanner.nextLine();
        Chips addedChips = null;

        if(wantChips.equalsIgnoreCase("Yes")) {

            while(true) {
                System.out.println("What kind of chips would you like?");
                int chipsCounter = 1;
                for(String chips : chipList) {
                    System.out.printf("%d. %s%n", chipsCounter++, chips);
                }
                System.out.println("0. I want to checkout");
                int chipIndex = scanner.nextInt();
                scanner.nextLine();

                if(chipIndex == 0) {
                    System.out.println("Ok let's checkout");
                    break;
                }

                String chipChoice = chipList[chipIndex -1];
                System.out.printf("You asked for %s chips", chipChoice);


                addedChips = new Chips(chipChoice);
                addedChips.addChips(addedChips);
            }
        }

        return addedChips;
    }

    public Drink askForDrink(Scanner scanner) {
        System.out.println("Would you like a drink? ");
        String wantDrink = scanner.nextLine();
        Drink addedDrink = null;
        if(wantDrink.equalsIgnoreCase("Yes")) {


            while(true) {
                System.out.println("What size drink would you like?");
                int sizeCounter = 1;
                for(String size : drinkSizes) {
                    System.out.printf("%d. %s%n", sizeCounter++, size);
                }
                System.out.println("0. Move onto chips");
                int sizeIndex = scanner.nextInt();
                scanner.nextLine();

                if(sizeIndex == 0) {
                    System.out.println("Ok, let's move onto chips!");
                    break;
                }

                String sizeChoice = drinkSizes[sizeIndex - 1];


                System.out.println("What flavor would you like? ");
                int flavorCounter = 1;
                for(String flavor : drinkFlavors) {
                    System.out.printf("%d. %s%n", flavorCounter++, flavor);
                }
                int drinkIndex = scanner.nextInt();
                scanner.nextLine();

                String flavorChoice = drinkFlavors[drinkIndex -1];
                System.out.printf("You asked for a %s %s", sizeChoice, flavorChoice);

                addedDrink = new Drink(sizeChoice, flavorChoice);
                addedDrink.addDrinks(addedDrink);
            }
        }
        return addedDrink;

    }

    public String askForName(Scanner scanner) {
        System.out.println("Name for the order? ");
        String name = scanner.nextLine();
        return name;
    }

    public int addToOrder(Scanner scanner) {
        System.out.println("What would you like to add to your order? ");
        System.out.println("1. Add a sandwich\n2. Add a drink\n3. Add a bag of chips \n4. Checkout please\n5. I want to cancel my order");
        int order = scanner.nextInt();
        return order;
    }


}
