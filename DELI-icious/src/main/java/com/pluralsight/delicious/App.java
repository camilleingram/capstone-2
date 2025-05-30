package com.pluralsight.delicious;

import com.pluralsight.delicious.ui.HomeScreen;

import java.util.Scanner;

public class App {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        HomeScreen homeScreen = new HomeScreen();
        homeScreen.displayHomeScreen(scanner);
        scanner.close();
    }
}
