package com.pluralsight.delicious;

import javax.sound.midi.SoundbankResource;
import java.util.Scanner;

public class HomeScreen {
    private String customerName = "";


    public void displayHomeScreen(Scanner scanner) {
        System.out.println("Welcome to DELI-cious Sandwich Shop!");
        int command = askIfOrdering(scanner);
        switch(command) {
            case 1:
                customerName = askForName(scanner);
                System.out.printf("Welcome, %s!", customerName);
                Customer customer = new Customer(customerName);
                Order newOrder = new Order();
                newOrder.displayMenu();
                break;
            case 0:
                System.out.println("We're sorry to see you go :( Come back soon!");
                break;
        }
    }

    public int askIfOrdering(Scanner scanner) {
        System.out.println("Would you like to place an order?");
        System.out.println("1. Yes please!" + "\n" + "0. No thank you"  );
        int command = scanner.nextInt();
        scanner.nextLine();
        return command;
    }

    public String askForName(Scanner scanner) {
        System.out.print("Name for the order? ");
        String name = scanner.nextLine();
        return name;
    }

}
