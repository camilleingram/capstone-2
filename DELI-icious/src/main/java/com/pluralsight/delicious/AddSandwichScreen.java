package com.pluralsight.delicious;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.pluralsight.delicious.App.scanner;

public class AddSandwichScreen {
    private String[] breadTypes = {"White", "Wheat", "Rye", "Wrap"};
    private String[] meatTypes = {"Steak", "Ham", "Salami", "Roast Beef", "Chicken", "Chicken"};
    private String[] cheeseTypes = {"American", "Provolone", "Cheddar", "Swiss"};
    private String[] regularToppings = {"Lettuce", "Peppers", "Onions", "Tomatoes", "Jalapeños", "Cucumbers", "Pickles", "Guacamole", "Mushrooms"};
    private String[] sauces = {"Mayo", "Ranch", "Thousand Island", "Vinaigrette"};
    private double price = 0;
    private static int sandwichSize = askForSize(scanner);
    private List<Topping> toppings = new ArrayList<>();
    private Sandwich.Builder sandwichBuilder = new Sandwich.Builder();

    public Sandwich displayAndBuildSandwich() {

        //        setting the sandwich size
        sandwichBuilder.setSandwichSize(sandwichSize);
        System.out.printf("You have selected the %d-inch sandwich%n", sandwichSize);

        int breadIndex = askForBread(scanner);
        String breadChoice = breadTypes[breadIndex - 1];
//        setting the bread for the sandwich
        sandwichBuilder.setBread(breadChoice);
        System.out.printf("You have selected %s bread%n", breadChoice);

        askIfToasted(scanner);

//        adding meat to the sandwich
        askForMeat(scanner);

//        adding cheese to the sandwich
        askForCheese(scanner);

//        adding regular toppings to the sandwich
        askForRegularTopping(scanner);

//        adding sauce to the sandwich
        askForSauce(scanner);

        return sandwichBuilder.build();


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

    public int askForSauce(Scanner scanner) {
        System.out.println("Would you like any sauce on your sandwich");
        String wantSauce = scanner.nextLine();
        int sauceIndex = 1;

        if(wantSauce.equalsIgnoreCase("Yes")) {

            while(true) {
                System.out.println("What sauce would you like? ");
                int sauceCounter = 1;
                for(String sauce : sauces) {
                    System.out.printf("%d. %s", sauceCounter, sauce);
                }
                System.out.println("0. Move on to the sides");
                sauceIndex = scanner.nextInt();
                scanner.nextLine();

                if(sauceIndex == 0) {
                    System.out.println("Ok let's move onto the sides!");
                    break;
                }

                String sauceChoice = sauces[sauceIndex - 1];
                Sauce addedSauce = new Sauce(false, sauceChoice, sandwichSize);

                System.out.printf("Would you like extra %s? ", sauceChoice);
                String extraSauce = scanner.nextLine();

                if(extraSauce.equalsIgnoreCase("Yes")) {
                    addedSauce.setExtra(true);
                    System.out.printf("You asked for extra %s%n", sauceChoice);
                } else if(extraSauce.equalsIgnoreCase("No")) {
                    System.out.printf("You asked for regular %s%n", sauceChoice);
                }

                sandwichBuilder.addSauce(addedSauce);
                addedSauce.addTopping(addedSauce);

            }
        }
        return sauceIndex;
    }

    public int askForRegularTopping(Scanner scanner) {
        System.out.print("Would like any of the regular toppings? ");
        String wantRegToppings = scanner.nextLine();
        int regIndex = 1;

        if(wantRegToppings.equalsIgnoreCase("Yes")) {
            while(true) {
                System.out.println("What topping would you like? ");
                int regToppingCounter = 1;
                for(String regTopping : regularToppings) {
                    System.out.printf("%d. %s ", regToppingCounter++, regTopping);
                }
                System.out.println("0. Move onto sauces");
                regIndex = scanner.nextInt();
                scanner.nextLine();

                if(regIndex == 0) {
                    System.out.println("Ok, let's move onto sauces");
                    break;
                }

                String regChoice = regularToppings[regIndex - 1];

                RegularTopping addedReg = new RegularTopping(false,regChoice, sandwichSize);

                System.out.printf("Would you like extra %s? ", regChoice);
                String extraReg = scanner.nextLine();

                if(extraReg.equalsIgnoreCase("Yes")) {
                    addedReg.setExtra(true);
                    System.out.printf("You asked for extra %s%n", regChoice);
                } else if(extraReg.equalsIgnoreCase("No")) {
                    System.out.printf("You asked for regular %s%n", regChoice);
                }

                sandwichBuilder.addTopping(addedReg);
                addedReg.addTopping(addedReg);
            }

        } else if(wantRegToppings.equalsIgnoreCase("No")) {
            System.out.println("Ok let's move onto sauces!");
        }
        return regIndex;
    }

    public int askForCheese(Scanner scanner) {
        System.out.print("Would you like cheese on your sandwich? ");
        String wantCheese = scanner.nextLine();
        int cheeseIndex = 1;

        if(wantCheese.equalsIgnoreCase("Yes")) {

            while(true) {
                System.out.println("What cheese would you like? ");
                int cheeseCounter = 1;
                for(String cheese : cheeseTypes) {
                    System.out.printf("%d. %s ", cheeseCounter++, cheese);
                }
                System.out.println("0. Move onto regular toppings");

                cheeseIndex = scanner.nextInt();
                scanner.nextLine();

                if(cheeseIndex == 0) {
                    System.out.println("Ok let's move on to regular toppings!");
                    break;
                }

                String cheeseChoice = cheeseTypes[cheeseIndex - 1];
                Cheese addedCheese = new Cheese(false, sandwichSize, cheeseChoice);

                System.out.printf("Would you like extra %s cheese? ", cheeseChoice);
                String extraCheese = scanner.nextLine();


                if(extraCheese.equalsIgnoreCase("Yes")) {
                    addedCheese.setExtra(true);
                    System.out.printf("You asked for extra %s cheese%n", cheeseChoice);
                } else if(extraCheese.equalsIgnoreCase("No")) {
                    System.out.printf("You asked for regular %s cheese%n", cheeseChoice);
                }

                sandwichBuilder.addTopping(addedCheese);
                addedCheese.addTopping(addedCheese);
            }

        } else if(wantCheese.equalsIgnoreCase("No")){
            System.out.println("Ok let's move to the regular toppings!");
        }

        return cheeseIndex;
    }

    public int askForMeat(Scanner scanner) {
        System.out.print("Would you like meat on your sandwich? ");
        String wantMeat = scanner.nextLine();
        int meatIndex = 1;
        if (wantMeat.equalsIgnoreCase("Yes")) {

            while (true) {

                System.out.println("What meat would you like? ");
                int toppingCounter = 1;
                for (String meat : meatTypes) {
                    System.out.printf("%d. %s ", toppingCounter++, meat);
                }
                System.out.println("0. Move onto cheese");

                meatIndex = scanner.nextInt();
                scanner.nextLine();

                if(meatIndex == 0) {
                    System.out.println("Ok, let's move onto cheese!");
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
                addedMeat.addTopping(addedMeat);


            }

        }else if(wantMeat.equalsIgnoreCase("No")) {
            System.out.println("Ok let's move onto cheese!");
        }


        return meatIndex;
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
