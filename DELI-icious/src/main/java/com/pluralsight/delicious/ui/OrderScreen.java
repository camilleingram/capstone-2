package com.pluralsight.delicious.ui;

import com.pluralsight.delicious.model.Sandwich;
import com.pluralsight.delicious.data.Checkout;
import com.pluralsight.delicious.model.Chips;
import com.pluralsight.delicious.model.Customer;
import com.pluralsight.delicious.model.Drink;
import com.pluralsight.delicious.model.Order;

import java.util.InputMismatchException;
import java.util.Scanner;

import static com.pluralsight.delicious.App.scanner;

public class OrderScreen {
    private String[] drinkSizes = {"Small", "Medium", "Large"};
    private String[] drinkFlavors = {"Sprite", "Dr. Pepper", "Mt. Dew", "Orange Fanta", "Lemonade", "Hi-C", "Water"};
    private String[] chipList = {"BBQ", "Salt & Vinegar", "Sour Cream & Cheddar", "Flamin' Hot Cheetos", "Nacho Cheese Doritos", "Lay's Potato Chips"};
    private Order order = new Order();

    public void displayOrderScreen() {
        HomeScreen homeScreen = new HomeScreen();
        String customerName = askForName(scanner);
        Customer customer = new Customer(customerName);
        System.out.printf("\nWelcome, %s! ", customer.getName());
        int orderType = addToOrder(scanner);

        while(orderType != 0) {
            switch(orderType) {
                case 1:
                    AddSandwichScreen sandwichScreen = new AddSandwichScreen();
                    Sandwich addedSandwich = sandwichScreen.displayAndBuildSandwich();
                    order.addSandwich(addedSandwich);
                    orderType = addToOrder(scanner);
                    break;
                case 2:
                    askForDrink(scanner);
                    orderType = addToOrder(scanner);
                    break;
                case 3:
                    askForChips(scanner);
                    orderType = addToOrder(scanner);
                    break;
                case 4:
                    Checkout checkout = new Checkout(order, customer);
                    checkout.displayOrderDetails();
                    System.out.println("\nThank you for ordering at DELI-cious! \nCome back soon!");
                    customer.addToPreviousOrders(order);
                    checkout.writeOrderToFile(order);
                    homeScreen.displayHomeScreen(scanner);
                    orderType = 0;
                    break;
                case 5:
                    System.out.println("Order cancelled");

                    homeScreen.displayHomeScreen(scanner);
                    break;
            }
        }



    }



    public void askForChips(Scanner scanner) {

        while(true) {
            System.out.println("\nWhat kind of chips would you like?");
            int chipsCounter = 1;
            for(String chips : chipList) {
                System.out.printf("%d. %s%n", chipsCounter++, chips);
            }
            System.out.println("0. Back to the main menu!");
            System.out.print("Enter Option: ");

            int chipIndex = 0;

            while (true) {
                try {
                    chipIndex = scanner.nextInt();
                    scanner.nextLine();

                    if (chipIndex >= 0 && chipIndex <= chipList.length) {
                        break;
                    } else {
                        System.out.println("Please enter a number between 0 and " + chipList.length);
                        System.out.print("Enter Option: ");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Please enter a number, not letters.");
                    scanner.nextLine();
                    System.out.print("Enter Option: ");
                }
            }
            if(chipIndex == 0) {
                System.out.println("\nBack to the main menu!");
                break;
            }

            String chipChoice = chipList[chipIndex -1];
            System.out.printf("%nYou asked for %s chips%n", chipChoice);


            Chips addedChips = new Chips(chipChoice);
            order.addChips(addedChips);
        }
    }

    public void askForDrink(Scanner scanner) {

        while(true) {
            System.out.println("\nWhat size drink would you like?");
            int sizeCounter = 1;
            for(String size : drinkSizes) {
                System.out.printf("%d. %s%n", sizeCounter++, size);
            }
            System.out.println("0. Back to main menu!");
            System.out.print("Enter Option: ");
            int sizeIndex = 0;

            while (true) {
                try {
                    sizeIndex = scanner.nextInt();
                    scanner.nextLine();

                    if (sizeIndex >= 0 && sizeIndex <= drinkSizes.length) {
                        break;
                    } else {
                        System.out.println("Please enter a number between 0 and " + drinkSizes.length);
                        System.out.print("Enter Option: ");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Please enter a number, not letters.");
                    scanner.nextLine();
                    System.out.print("Enter Option: ");
                }
            }

            if(sizeIndex == 0) {
                System.out.println("\nBack to the main menu!");
                break;
            }

            String sizeChoice = drinkSizes[sizeIndex - 1];


            System.out.println("\nWhat flavor would you like? ");
            int flavorCounter = 1;
            for(String flavor : drinkFlavors) {
                System.out.printf("%d. %s%n", flavorCounter++, flavor);
            }
            System.out.print("Enter Option: ");
            int drinkIndex = 0;

            while (true) {
                try {
                    drinkIndex = scanner.nextInt();
                    scanner.nextLine();

                    if (drinkIndex >= 1 && drinkIndex <= drinkFlavors.length) {
                        break;
                    } else {
                        System.out.println("Please enter a number between 1 and " + drinkFlavors.length);
                        System.out.print("Enter Option: ");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Please enter a number, not letters.");
                    scanner.nextLine();
                    System.out.print("Enter Option: ");
                }
            }

            String flavorChoice = drinkFlavors[drinkIndex -1];
            System.out.printf("%nYou asked for a %s %s%n", sizeChoice, flavorChoice);

            Drink addedDrink = new Drink(sizeChoice, flavorChoice);
            order.addDrink(addedDrink);

        }
    }

    public String askForName(Scanner scanner) {
        while (true) {
            System.out.print("\nName for the order? ");
            String name = scanner.nextLine().trim();

            if (!name.isEmpty()) {
                return name;
            } else {
                System.out.print("Please enter a name.");
            }
        }
    }

    public int addToOrder(Scanner scanner) {
        while (true) {
            System.out.println("\nWhat would you like to add to your order? ");
            System.out.println("1. Add a sandwich\n2. Add a drink\n3. Add a bag of chips \n4. Checkout please\n5. I want to cancel my order");
            System.out.print("Enter Option: ");

            try {
                int order = scanner.nextInt();
                scanner.nextLine();

                if (order >= 1 && order <= 5) {
                    return order;
                } else {
                    System.out.println("Please enter a number between 1 and 5.");

                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter a number, not letters.");
                scanner.nextLine();
            }
        }
    }


}
