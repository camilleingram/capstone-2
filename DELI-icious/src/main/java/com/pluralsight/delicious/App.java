package com.pluralsight.delicious;

import java.util.Scanner;

public class App {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        HomeScreen homeScreen = new HomeScreen();
        homeScreen.displayHomeScreen(scanner);
    }
}
