package com.pluralsight.delicious.ui;

import com.pluralsight.delicious.model.*;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import static com.pluralsight.delicious.App.scanner;

public class AddSandwichScreen {
    private String[] breadTypes = {"White", "Wheat", "Rye", "Wrap"};
    private String[] meatTypes = {"Steak", "Ham", "Salami", "Roast Beef", "Chicken", "Bacon"};
    private String[] cheeseTypes = {"American", "Provolone", "Cheddar", "Swiss"};
    private String[] regularToppings = {"Lettuce", "Peppers", "Onions", "Tomatoes", "Jalapeños", "Cucumbers", "Pickles", "Guacamole", "Mushrooms"};
    private String[] sauces = {"Mayo", "Ranch", "Thousand Island", "Vinaigrette"};
    private static int sandwichSize;
    private Sandwich.Builder sandwichBuilder = new Sandwich.Builder();

    public Sandwich displayAndBuildSandwich() {

        System.out.println("\nWhat kind of sandwich would you like?");
        System.out.println("1. Signature sandwich\n2. Create-Your-Own");
        System.out.print("Enter Option: ");
        int sandwichChoice = 0;

        while (true) {
            try {
                sandwichChoice = scanner.nextInt();
                scanner.nextLine();

                if (sandwichChoice == 1 || sandwichChoice == 2) {
                    break;
                } else {
                    System.out.println("Please enter 1 or 2 only.");
                    System.out.print("Enter Option: ");
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter a number, not letters.");
                scanner.nextLine();
                System.out.print("Enter Option: ");
            }
        }

        if(sandwichChoice == 1) {
            askForSignatureSandwich(scanner);
        } else {
            sandwichSize = askForSize(scanner);
            sandwichBuilder.setSandwichSize(sandwichSize);
            System.out.printf("%nYou have selected the %d-inch sandwich%n", sandwichSize);

            int breadIndex = askForBread(scanner);
            String breadChoice = breadTypes[breadIndex - 1];

            Bread addedBread = new Bread(breadChoice, sandwichSize);
            sandwichBuilder.setBread(addedBread);
            System.out.printf("%nYou have selected %s bread%n", breadChoice);

            askIfToasted(scanner);

            askForMeat(scanner);

            askForCheese(scanner);

            askForRegularTopping(scanner);

            askForSauce(scanner);
        }

        return sandwichBuilder.build();
    }

    public void askForModifications(Scanner scanner) {
        System.out.println("\nWhat would you like to modify? ");
        System.out.println("1. Add more meat\n2. Add more cheese\n3. Add toppings\n4. Remove toppings\n0. Done with changes\n");
        System.out.print("Enter Option: ");

        int modChoice = 0;
        while (true) {
            try {
                modChoice = scanner.nextInt();
                scanner.nextLine();

                if (modChoice >= 0 && modChoice <= 4) {
                    break;
                } else {
                    System.out.println("Please enter a number between 0 and 4.");
                    System.out.print("Enter Option: ");
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter a number, not letters.");
                scanner.nextLine();
                System.out.print("Enter Option: ");
            }
        }
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
        System.out.println("\nWhat do you want to remove? ");
        int toppingCounter = 1;
        for(Topping topping : currentToppings) {
            System.out.printf("%d. %s%n", toppingCounter++, topping.getToppingName());
        }
        System.out.print("Enter Option: ");
        int removeIndex = 0;

        while (true) {
            try {
                removeIndex = scanner.nextInt();
                scanner.nextLine();

                if (removeIndex >= 1 && removeIndex <= currentToppings.size()) {
                    break;
                } else {
                    System.out.println("Please enter a number between 1 and " + currentToppings.size());
                    System.out.print("Enter Option: ");
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter a number, not letters.");
                scanner.nextLine();
                System.out.print("Enter Option: ");
            }
        }

        Topping removeChoice = currentToppings.get(removeIndex - 1);
        sandwichBuilder.removeTopping(removeChoice);
    }

    public void askForSignatureSandwich(Scanner scanner) {

        System.out.println("\nHere is a list of our DELI-cious signatures!");
        System.out.println("1. BLT\n2.Garden Wrap\n3.The Steak House");
        System.out.print("Enter Option: ");
        int signatureChoice = 0;
        while (true) {
            try {
                signatureChoice = scanner.nextInt();
                scanner.nextLine();

                if (signatureChoice >= 1 && signatureChoice <= 3) {
                    break;
                } else {
                    System.out.println("Please enter a number between 1 and 3.");
                    System.out.print("Enter Option: ");
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter a number, not letters.");
                scanner.nextLine();
                System.out.print("Enter Option: ");
            }
        }
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
                    "\nYour BLT sandwich has: White bread (toasted), Bacon, Cheddar Cheese, Lettuce, Tomatoes, Ranch sauce");

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

            System.out.println("\nYour Garden Wrap has: Wrap bread (not toasted), Chicken, Swiss Cheese, Lettuce, Tomatoes, " +
                               "Cucumbers, Guacamole, Ranch sauce");

            askForModifications(scanner);

        } else {
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

            System.out.println("\nYour Steak House sandwich has: White bread (toasted), Steak, Cheddar Cheese, Mushrooms, " +
                               "Onions, Vinaigrette sauce");

            askForModifications(scanner);
        }
    }


    public void askIfToasted(Scanner scanner) {
        System.out.print("\nWould you like the sandwich toasted? ");
        String wantToasted = scanner.nextLine();

        if(wantToasted.equalsIgnoreCase("Yes")) {
            sandwichBuilder.setToasted(true);
            System.out.println("\nYou asked for a toasted sandwich");
        } else if(wantToasted.equalsIgnoreCase("No")) {
            sandwichBuilder.setToasted(false);
            System.out.println("\nYou asked for a non-toasted sandwich");
        } else {
            System.out.println("\nInvalid input. Defaulting to not toasted.");
            sandwichBuilder.setToasted(false);
        }
    }

    public void askForSauce(Scanner scanner) {

        while(true) {
            System.out.println("\nWhat sauce would you like? ");
            int sauceCounter = 1;
            for(String sauce : sauces) {
                System.out.printf("%d. %s%n", sauceCounter++, sauce);
            }
            System.out.println("0. Back to the main menu!");
            System.out.print("Enter Option: ");
            int sauceIndex = 0;

            while (true) {
                try {
                    sauceIndex = scanner.nextInt();
                    scanner.nextLine();

                    if (sauceIndex >= 0 && sauceIndex <= sauces.length) {
                        break;
                    } else {
                        System.out.println("Please enter a number between 0 and " + sauces.length);
                        System.out.print("Enter Option: ");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Please enter a number, not letters.");
                    scanner.nextLine();
                    System.out.print("Enter Option: ");
                }
            }


            if(sauceIndex == 0) {
                System.out.println("\nBack to the main menu!");
                break;
            }

            String sauceChoice = sauces[sauceIndex - 1];
            RegularTopping addedSauce = new RegularTopping(false, sandwichSize, sauceChoice);

            System.out.printf("%nWould you like extra %s? ", sauceChoice);
            String extraSauce = scanner.nextLine();

            if(extraSauce.equalsIgnoreCase("Yes")) {
                addedSauce.setExtra(true);
                System.out.printf("%nYou asked for extra %s%n", sauceChoice);
            } else if(extraSauce.equalsIgnoreCase("No")) {
                System.out.printf("%nYou asked for regular %s%n", sauceChoice);
            }else {
                System.out.printf("%nInvalid input. Defaulting to regular %s.%n", addedSauce.getToppingName());
                addedSauce.setExtra(false);
            }

            sandwichBuilder.addSauce(addedSauce);

        }

    }

    public void askForRegularTopping(Scanner scanner) {

        while (true) {
            System.out.println("\nWhat topping would you like? ");
            int regToppingCounter = 1;
            for (String regTopping : regularToppings) {
                System.out.printf("%d. %s%n", regToppingCounter++, regTopping);
            }
            System.out.println("0. On to the next step!");
            System.out.print("Enter Option: ");
            int regIndex = 0;

            while (true) {
                try {
                    regIndex = scanner.nextInt();
                    scanner.nextLine();

                    if (regIndex >= 0 && regIndex <= regularToppings.length) {
                        break;
                    } else {
                        System.out.println("Please enter a number between 0 and " + regularToppings.length);
                        System.out.print("Enter Option: ");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Please enter a number, not letters.");
                    scanner.nextLine();
                    System.out.print("Enter Option: ");
                }
            }

            if (regIndex == 0) {
                System.out.println("\nOn to the next step!");
                break;
            }

            String regChoice = regularToppings[regIndex - 1];

            RegularTopping addedReg = new RegularTopping(false, sandwichSize, regChoice);

            System.out.printf("%nWould you like extra %s? ", regChoice);
            String extraReg = scanner.nextLine();

            if (extraReg.equalsIgnoreCase("Yes")) {
                addedReg.setExtra(true);
                System.out.printf("%nYou asked for extra %s%n", regChoice);
            } else if (extraReg.equalsIgnoreCase("No")) {
                System.out.printf("%nYou asked for regular %s%n", regChoice);
            }else {
                System.out.printf("%nInvalid input. Defaulting to regular %s.%n", addedReg.getToppingName());
                addedReg.setExtra(false);
            }

            sandwichBuilder.addTopping(addedReg);

        }
    }

    public void askForCheese(Scanner scanner) {

        while(true) {
            System.out.println("\nWhat cheese would you like? ");
            int cheeseCounter = 1;
            for(String cheese : cheeseTypes) {
                System.out.printf("%d. %s%n", cheeseCounter++, cheese);
            }
            System.out.println("0. On to the next step!");
            System.out.print("Enter Option: ");

            int cheeseIndex = 0;
            while (true) {
                try {
                    cheeseIndex = scanner.nextInt();
                    scanner.nextLine();

                    if (cheeseIndex >= 0 && cheeseIndex <= cheeseTypes.length) {
                        break;
                    } else {
                        System.out.println("Please enter a number between 0 and " + cheeseTypes.length);
                        System.out.print("Enter Option: ");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Please enter a number, not letters.");
                    scanner.nextLine();
                    System.out.print("Enter Option: ");
                }
            }

            if(cheeseIndex == 0) {
                System.out.println("\nOn to the next step!");
                break;
            }

            String cheeseChoice = cheeseTypes[cheeseIndex - 1];

            System.out.printf("\nWould you like extra %s cheese? ", cheeseChoice);
            String extraCheese = scanner.nextLine();

            Cheese addedCheese = new Cheese(false, sandwichSize, cheeseChoice);
            if(extraCheese.equalsIgnoreCase("Yes")) {
                addedCheese.setExtra(true);
                System.out.printf("%nYou asked for extra %s cheese%n", cheeseChoice);
            } else if(extraCheese.equalsIgnoreCase("No")) {
                System.out.printf("%nYou asked for regular %s cheese%n", cheeseChoice);
            }else {
                System.out.printf("%nInvalid input. Defaulting to regular %s.%n", addedCheese.getToppingName());
                addedCheese.setExtra(false);
            }

            sandwichBuilder.addTopping(addedCheese);
        }
    }

    public void askForMeat(Scanner scanner) {

        while (true) {

            System.out.println("\nWhat meat would you like? ");
            int toppingCounter = 1;
            for (String meat : meatTypes) {
                System.out.printf("%d. %s%n", toppingCounter++, meat);
            }
            System.out.println("0. On to the next step!");
            System.out.print("Enter Option: ");

            int meatIndex = 0;
            while (true) {
                try {
                    meatIndex = scanner.nextInt();
                    scanner.nextLine();

                    if (meatIndex >= 0 && meatIndex <= meatTypes.length) {
                        break;
                    } else {
                        System.out.println("Please enter a number between 0 and " + meatTypes.length);
                        System.out.print("Enter Option: ");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Please enter a number, not letters.");
                    scanner.nextLine();
                    System.out.print("Enter Option: ");
                }
            }

            if(meatIndex == 0) {
                System.out.println("\nOn to the next step!");
                break;
            }

            String meatChoice = meatTypes[meatIndex - 1];
            Meat addedMeat = new Meat(false, sandwichSize, meatChoice);

            System.out.printf("\nWould you like extra %s? ", meatChoice);
            String extraMeat = scanner.nextLine();

            if (extraMeat.equalsIgnoreCase("Yes")) {
                addedMeat.setExtra(true);
                System.out.printf("%nYou asked for extra %s%n", meatChoice);
            } else if (extraMeat.equalsIgnoreCase("No")) {
                System.out.printf("%nYou asked for regular %s%n", meatChoice);
            }else {
                System.out.printf("%nInvalid input. Defaulting to regular %s.%n", addedMeat.getToppingName());
                addedMeat.setExtra(false);
            }

            sandwichBuilder.addTopping(addedMeat);

        }
    }

    public static int askForSize(Scanner scanner) {
        while (true) {
            System.out.println("\nWhat size sandwich would you like?");
            System.out.println("(4) 4-inch Sandwich\n(8) 8-inch sandwich\n(12) 12-inch sandwich");
            System.out.print("Enter Option: ");

            try {
                int sandwichSize = scanner.nextInt();
                scanner.nextLine();

                if (sandwichSize == 4 || sandwichSize == 8 || sandwichSize == 12) {
                    return sandwichSize;
                } else {
                    System.out.println("Please enter 4, 8, or 12 only.");
                    System.out.print("Enter Option: ");
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter a number, not letters.");
                scanner.nextLine();
                System.out.print("Enter Option: ");
            }
        }
    }


    public int askForBread(Scanner scanner) {
        while (true) {
            System.out.println("\nWhat kind of bread would you like?");
            System.out.println("1. White\n 2. Wheat\n 3. Rye\n 4. Wrap");
            System.out.print("Enter Option: ");
            try {
                int bread = scanner.nextInt();
                scanner.nextLine();

                if (bread >= 1 && bread <= 4) {
                    return bread;
                } else {
                    System.out.println("Please enter a number between 1 and 4.");
                    System.out.print("Enter Option: ");
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter a number, not letters.");
                scanner.nextLine();
                System.out.print("Enter Option: ");
            }
        }
    }


}
