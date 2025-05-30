package com.pluralsight.delicious;

import java.util.InputMismatchException;
import java.util.Scanner;

public class HomeScreen {

    public void displayHomeScreen(Scanner scanner) {
        System.out.println("\nWelcome to DELI-cious Sandwich Shop!");
        int command = askIfOrdering(scanner);
        switch(command) {
            case 1:
                OrderScreen orderScreen = new OrderScreen();
                orderScreen.displayOrderScreen();
                break;
            case 0:
                System.out.println("We're sorry to see you go :( Come back soon!");
                break;
        }
    }


    public int askIfOrdering(Scanner scanner) {
        while (true) {
            System.out.println("Would you like to place an order?");
            System.out.println("1. I'm hungry!\n0. No thank you");
            System.out.print("Enter Option: ");

            try {
                int command = scanner.nextInt();
                scanner.nextLine();

                if (command == 0 || command == 1) {
                    return command;
                } else {
                    System.out.println("Please enter 0 or 1 only.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter a number, not letters.");
                scanner.nextLine();
            }
        }
    }



}
