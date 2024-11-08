package com.pluralsight;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInterface {
    // Data fields
    Order order;
    Scanner scanner = new Scanner(System.in);

    public UserInterface() {

    }

    private void init() {
        // this.order = OrderFileManager.getReceipt();
    }

    public void display() {
        init();

        while (true) {
            try {
                // Home Screen
                System.out.print("""
                        Welcome to DELI-cious Sandwich Shop!
                        ------------------------------------
                        Select an option to continue.
                        1) New Order
                        0) Exit
                                
                        Please enter your option (1 or 0): \
                        """);

                int option = scanner.nextInt();
                scanner.nextLine();

                switch (option) {
                    case 1:
                        processAddOrderRequest();
                        break;
                    case 0:
                        scanner.close();
                        System.exit(0);
                    default:
                        System.out.println("Invalid input. Please enter a valid choice (1 or 0).\n");
                }

            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("Error. Enter a numeric value from the options given. (1,2,3,4,5, or 0).\n");
            }
        }
    }

    public void processAddOrderRequest() {


    }
}
