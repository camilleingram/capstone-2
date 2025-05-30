package com.pluralsight.delicious;

import java.util.Scanner;

public class HomeScreen {

    public void displayHomeScreen(Scanner scanner) {
        System.out.println("Welcome to DELI-cious Sandwich Shop!");
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
        System.out.println("Would you like to place an order?");
        System.out.println("1. Yes please!\n0. No thank you"  );
        int command = scanner.nextInt();
        scanner.nextLine();
        return command;
    }



}
