package com.pluralsight.delicious;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.pluralsight.delicious.App.scanner;

public class AddSandwichScreen {
    private String[] breadTypes = {"White", "Wheat", "Rye", "Wrap"};
    private String[] meatTypes = {"Steak", "Ham", "Salami", "Roast Beef", "Chicken", "Bacon"};
    private String[] cheeseTypes = {"American", "Provolone", "Cheddar", "Swiss"};
    private String[] regularToppings = {"Lettuce", "Peppers", "Onions", "Tomatoes", "Jalapeños", "Cucumbers", "Pickles", "Guacamole", "Mushrooms"};
    private String[] sauces = {"Mayo", "Ranch", "Thousand Island", "Vinaigrette"};
    private double price = 0;
    private static int sandwichSize;
    private List<Topping> toppings = new ArrayList<>();
    private Sandwich.Builder sandwichBuilder = new Sandwich.Builder();

    public Sandwich displayAndBuildSandwich() {

        System.out.println("What kind of sandwich would you like?");
        System.out.println("1. Signature sandwich\n2. Create-Your-Own\n");
        System.out.print("Enter Option: ");
        int sandwichChoice = scanner.nextInt();
        scanner.nextLine();

        if(sandwichChoice == 1) {
            askForSignatureSandwich(scanner);
        } else if(sandwichChoice == 2) {
            sandwichSize = askForSize(scanner);
            sandwichBuilder.setSandwichSize(sandwichSize);
            System.out.printf("You have selected the %d-inch sandwich%n", sandwichSize);

            int breadIndex = askForBread(scanner);
            String breadChoice = breadTypes[breadIndex - 1];

            Bread addedBread = new Bread(breadChoice, sandwichSize);
            sandwichBuilder.setBread(addedBread);
            System.out.printf("You have selected %s bread%n", breadChoice);

            askIfToasted(scanner);

            askForMeat(scanner);

            askForCheese(scanner);

            askForRegularTopping(scanner);

            askForSauce(scanner);
        }

        return sandwichBuilder.build();
    }

    public void askForModifications(Scanner scanner) {
        System.out.println("What would you like to modify? ");
        System.out.println("");
        System.out.println("1. Add more meat\n2. Add more cheese\n3. Add toppings\n4.Remove toppings\n0. Done with changes\n");
        System.out.print("Enter option: ");

        int modChoice = scanner.nextInt();
        scanner.nextLine();

        switch(modChoice) {
            case 1:
                askForMeat(scanner);
                break;
            case 2:
                askForCheese(scanner);
                break;
            case 3:
                askForRegularTopping(scanner);
                break;
            case 4:
                removeToppings(scanner);
                break;
            case 0:
                System.out.println("Back to the main menu!");
                break;
        }
    }

    public void removeToppings(Scanner scanner) {
        List<Topping> currentToppings = sandwichBuilder.getToppings();
        System.out.println("What do you want to remove? ");
        int toppingCounter = 1;
        for(Topping topping : currentToppings) {
            System.out.printf("%d. %s%n", toppingCounter++, topping.getToppingName());
        }
        System.out.print("Enter option: ");
        int removeIndex = scanner.nextInt();
        scanner.nextLine();

        Topping removeChoice = currentToppings.get(removeIndex - 1);
        sandwichBuilder.removeTopping(removeChoice);
    }

    public void askForSignatureSandwich(Scanner scanner) {

        System.out.println("Here is a list of our DELI-cious signatures!");
        System.out.println("1. BLT\n2.Garden Wrap\n3.The Steak House");
        int signatureChoice = scanner.nextInt();
        scanner.nextLine();

        if (signatureChoice == 1) {
            sandwichBuilder.setSandwichSize(8);

            Bread bread = new Bread("White", 8);
            sandwichBuilder.setBread(bread);

            sandwichBuilder.setToasted(true);

            Meat addedMeat = new Meat(false, 8, "Bacon");
            sandwichBuilder.addTopping(addedMeat);

            Cheese addedCheese = new Cheese(false, 8, "Cheddar");
            sandwichBuilder.addTopping(addedCheese);

            RegularTopping addedReg = new RegularTopping(false, 8, "Lettuce");
            sandwichBuilder.addTopping(addedReg);
            RegularTopping addedReg2 = new RegularTopping(false, 8, "Tomatoes");
            sandwichBuilder.addTopping(addedReg2);

            RegularTopping addedSauce = new RegularTopping(false, 8, "Ranch");
            sandwichBuilder.addSauce(addedSauce);
            System.out.println(
                    "Your BLT sandwich has: White bread (toasted), Bacon, Cheddar Cheese, Lettuce, Tomatoes, Ranch sauce");

            askForModifications(scanner);

        } else if (signatureChoice == 2) {

            sandwichBuilder.setSandwichSize(4);

            Bread bread = new Bread("Wrap", 4);
            sandwichBuilder.setBread(bread);

            sandwichBuilder.setToasted(false);

            Meat addedMeat = new Meat(false, 4, "Chicken");
            sandwichBuilder.addTopping(addedMeat);

            Cheese addedCheese = new Cheese(false, 4, "Swiss");
            sandwichBuilder.addTopping(addedCheese);

            RegularTopping addedReg = new RegularTopping(false, 4, "Lettuce");
            sandwichBuilder.addTopping(addedReg);
            RegularTopping addedReg2 = new RegularTopping(false, 4, "Tomatoes");
            sandwichBuilder.addTopping(addedReg2);
            RegularTopping addedReg3 = new RegularTopping(false, 4, "Cucumbers");
            sandwichBuilder.addTopping(addedReg3);
            RegularTopping addedReg4 = new RegularTopping(false, 4, "Guacamole");
            sandwichBuilder.addTopping(addedReg4);

            RegularTopping addedSauce = new RegularTopping(false, 4, "Ranch");
            sandwichBuilder.addSauce(addedSauce);

            System.out.println("Your Garden Wrap has: Wrap bread (not toasted), Chicken, Swiss Cheese, Lettuce, Tomatoes, Cucumbers, Guacamole, Ranch sauce");

            askForModifications(scanner);

        } else if (signatureChoice == 3) {
            sandwichBuilder.setSandwichSize(12);

            Bread bread = new Bread("White", 12);
            sandwichBuilder.setBread(bread);

            sandwichBuilder.setToasted(true);

            Meat addedMeat = new Meat(true, 12, "Steak");
            sandwichBuilder.addTopping(addedMeat);

            Cheese addedCheese = new Cheese(false, 12, "Cheddar");
            sandwichBuilder.addTopping(addedCheese);

            RegularTopping addedReg = new RegularTopping(false, 12, "Mushrooms");
            sandwichBuilder.addTopping(addedReg);
            RegularTopping addedReg2 = new RegularTopping(false, 12, "Onions");
            sandwichBuilder.addTopping(addedReg2);

            RegularTopping addedSauce = new RegularTopping(false, 12, "Vinaigrette");
            sandwichBuilder.addSauce(addedSauce);

            System.out.println("Your Steak House sandwich has: White bread (toasted), Steak, Cheddar Cheese, Mushrooms, Onions, Vinaigrette sauce");

            askForModifications(scanner);
        }
    }


    public void askIfToasted(Scanner scanner) {
        System.out.print("Would you like the sandwich toasted?");
        String wantToasted = scanner.nextLine();

        if(wantToasted.equalsIgnoreCase("Yes")) {
            sandwichBuilder.setToasted(true);
            System.out.println("You asked for a toasted sandwich");
        } else if(wantToasted.equalsIgnoreCase("No")) {
            sandwichBuilder.setToasted(false);
        }
    }

    public void askForSauce(Scanner scanner) {

        while(true) {
            System.out.println("What sauce would you like? ");
            int sauceCounter = 1;
            for(String sauce : sauces) {
                System.out.printf("%d. %s%n", sauceCounter++, sauce);
            }
            System.out.println("0. Head to the main menu!");
            int sauceIndex = scanner.nextInt();
            scanner.nextLine();


            if(sauceIndex == 0) {
                System.out.println("0. On to the next step!");
                break;
            }

            String sauceChoice = sauces[sauceIndex - 1];
            RegularTopping addedSauce = new RegularTopping(false, sandwichSize, sauceChoice);

            System.out.printf("Would you like extra %s? ", sauceChoice);
            String extraSauce = scanner.nextLine();

            if(extraSauce.equalsIgnoreCase("Yes")) {
                addedSauce.setExtra(true);
                System.out.printf("You asked for extra %s%n", sauceChoice);
            } else if(extraSauce.equalsIgnoreCase("No")) {
                System.out.printf("You asked for regular %s%n", sauceChoice);
            }

            sandwichBuilder.addSauce(addedSauce);

        }

    }

    public void askForRegularTopping(Scanner scanner) {

        while (true) {
            System.out.println("What topping would you like? ");
            int regToppingCounter = 1;
            for (String regTopping : regularToppings) {
                System.out.printf("%d. %s%n", regToppingCounter++, regTopping);
            }
            System.out.println("0. On to the next step!");
            int regIndex = scanner.nextInt();
            scanner.nextLine();

            if (regIndex == 0) {
                System.out.println("0. On to the next step!");
                break;
            }

            String regChoice = regularToppings[regIndex - 1];

            RegularTopping addedReg = new RegularTopping(false, sandwichSize, regChoice);

            System.out.printf("Would you like extra %s? ", regChoice);
            String extraReg = scanner.nextLine();

            if (extraReg.equalsIgnoreCase("Yes")) {
                addedReg.setExtra(true);
                System.out.printf("You asked for extra %s%n", regChoice);
            } else if (extraReg.equalsIgnoreCase("No")) {
                System.out.printf("You asked for regular %s%n", regChoice);
            }

            sandwichBuilder.addTopping(addedReg);

        }
    }

    public void askForCheese(Scanner scanner) {

        while(true) {
            System.out.println("What cheese would you like? ");
            int cheeseCounter = 1;
            for(String cheese : cheeseTypes) {
                System.out.printf("%d. %s%n", cheeseCounter++, cheese);
            }
            System.out.println("0. On to the next step!");

            int cheeseIndex = scanner.nextInt();
            scanner.nextLine();

            if(cheeseIndex == 0) {
                System.out.println("0. On to the next step!");
                break;
            }

            String cheeseChoice = cheeseTypes[cheeseIndex - 1];

            System.out.printf("Would you like extra %s cheese? ", cheeseChoice);
            String extraCheese = scanner.nextLine();

            Cheese addedCheese = new Cheese(false, sandwichSize, cheeseChoice);
            if(extraCheese.equalsIgnoreCase("Yes")) {
                addedCheese.setExtra(true);
                System.out.printf("You asked for extra %s cheese%n", cheeseChoice);
            } else if(extraCheese.equalsIgnoreCase("No")) {
                System.out.printf("You asked for regular %s cheese%n", cheeseChoice);
            }

            sandwichBuilder.addTopping(addedCheese);
        }
    }

    public void askForMeat(Scanner scanner) {

        while (true) {

            System.out.println("What meat would you like? ");
            int toppingCounter = 1;
            for (String meat : meatTypes) {
                System.out.printf("%d. %s%n", toppingCounter++, meat);
            }
            System.out.println("0. On to the next step!");

            int meatIndex = scanner.nextInt();
            scanner.nextLine();

            if(meatIndex == 0) {
                System.out.println("0. On to the next step!");
                break;
            }

            String meatChoice = meatTypes[meatIndex - 1];
            Meat addedMeat = new Meat(false, sandwichSize, meatChoice);

            System.out.printf("Would you like extra %s%n", meatChoice);
            String extraMeat = scanner.nextLine();

            if (extraMeat.equalsIgnoreCase("Yes")) {
                addedMeat.setExtra(true);
                System.out.printf("You asked for extra %s%n", meatChoice);
            } else if (extraMeat.equalsIgnoreCase("No")) {
                System.out.printf("You asked for regular %s%n", meatChoice);
            }

            sandwichBuilder.addTopping(addedMeat);

        }
    }

    public static int askForSize(Scanner scanner) {
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
