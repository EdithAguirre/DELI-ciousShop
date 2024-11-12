package com.pluralsight;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    // Data fields
    Order order;
    Scanner scanner = new Scanner(System.in);

    public UserInterface() {
    }

//    private void init() {
//        // this.order = OrderFileManager.getReceipt();
//    }

    public void display() {
        //init();

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
        // Create an order by the name of the customer
        System.out.print("Enter your name: ");
        String customerName = scanner.nextLine().trim();
        order = new Order(customerName);

        while(true) {
            try {
                // Display order screen
                System.out.print("""
                        Order Screen
                        ---------------
                        1) Add Sandwich
                        2) Add Drink
                        3) Add Chips
                        4) Checkout
                        0) Cancel Order
                         
                        Please enter a choice: \
                         """);
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        processAddSandwichRequest();
                        break;
                    case 2:
                        processAddDrinkRequest();
                        break;
                    case 3:
                        processAddChipsRequest();
                        break;
                    case 4:
                        processCheckOutRequest();
                        break;
                    case 0:
                        processCancelOrderRequest();
                        return;
                    default:
                        System.out.println("Invalid. Enter a valid choice (1,2,3,4, or 0).");
                        break;
                }
                System.out.println("\nSuccessfully added! Would you like to add something else to your order?");

            }catch(InputMismatchException e){
                scanner.nextLine();
                System.out.println("Error. Enter a numeric value from the options given. (1,2,3,4,5, or 0).\n");
            }
        }
    }

    public void processAddSandwichRequest() {
        System.out.print("Select your bread (white, wheat, rye, wrap): ");
        String breadType = scanner.nextLine().trim();

        System.out.print("Sandwich size (4,8,12): ");
        int size = scanner.nextInt();
        scanner.nextLine();

        List<Topping> toppings = processAddToppingsRequest();

        System.out.print("Would you like the sandwich toasted? (Yes or No): ");
        boolean toasted = (scanner.nextLine().trim().equalsIgnoreCase("Yes"));

        System.out.print("Would you like a side with your order? (au jus, sauce, or none): ");
        String side = scanner.nextLine();

        System.out.print("""
        Which sauce would you like to include with your order?
        (mayo, mustard, ketchup, ranch, thousand islands, vinaigrette, none)
        Enter the sauce: \
        """);
        String sauce = scanner.nextLine();

        order.addProduct(new Sandwich(size, breadType, toppings,toasted, side, sauce));
    }

    public List<Topping> processAddToppingsRequest() {
        List<Topping> tempToppings = new ArrayList<>();

        System.out.print("""
        Regular Toppings:
        ~~~~~~~~~~~~~~~~~
        (lettuce, peppers, onions, tomatoes, jalapenos,
         cucumbers, pickles, guacamole, mushrooms, or none)
         
        How many regular toppings would you like to add? (Enter 0 if none): \
        """);
        int regularToppingsCount = scanner.nextInt();
        scanner.nextLine();

        if(regularToppingsCount != 0) {
            for (int i = 0; i < regularToppingsCount; i++) {
                System.out.print("Enter a topping to add: ");
                tempToppings.add(new Topping(false, scanner.nextLine().trim()));
            }
        }

        System.out.print("""
        Premium Toppings
        ~~~~~~~~~~~~~~~~~~
        Meats: (steak, ham, salami, roast beef, chicken, bacon, or none)
       
        Premium toppings come at an additional cost. How many premium meat toppings total would you like to add?
        (Enter 0 if none): \
        """);
        int meatToppingsCount = scanner.nextInt();
        scanner.nextLine();

        if(meatToppingsCount != 0) {
            for (int i = 0; i < regularToppingsCount; i++) {
                System.out.print("Enter a topping to add: ");
                String topping = scanner.nextLine().trim();
                System.out.print("Extra meat?(Y for yes or N for no): ");
                boolean extra = (scanner.nextLine().trim().equalsIgnoreCase("Y"));
                tempToppings.add(new Topping(true, topping, extra, true));
            }
        }
        System.out.print("""
        Premium Toppings
        ~~~~~~~~~~~~~~~~~~
        Cheese: (american, provolone, cheddar, swiss, or none)
       
        Premium toppings come at an additional cost. How many premium meat toppings total would you like to add?
        (Enter 0 if none): \
        """);
        int cheeseToppingsCount = scanner.nextInt();
        scanner.nextLine();

        if(cheeseToppingsCount != 0) {
            for (int i = 0; i < regularToppingsCount; i++) {
                System.out.print("Enter a topping to add: ");
                String topping = scanner.nextLine().trim();
                System.out.print("Extra cheese?(Y for yes or N for no): ");
                boolean extra = (scanner.nextLine().trim().equalsIgnoreCase("Y"));
                tempToppings.add(new Topping(true, topping, extra, false));
            }
        }

        return tempToppings;
    }

    public void processAddDrinkRequest() {
        System.out.print("""
                Select drink size.
                (1) Small  (2) Medium  (3) Large
                Enter your choice: \
                """);
        int drinkSize = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Select flavor (Sprite, Coke, Pepsi): ");
        String flavor = scanner.nextLine().trim();

        order.addProduct(new Drink(drinkSize,flavor));
    }
    public void processAddChipsRequest() {
        System.out.print("Select chip type (Cheetos, Doritos, Lay's, Takis): ");
        String chipType = scanner.nextLine().trim();

        order.addProduct(new Chips(chipType));
    }
    public void processCheckOutRequest() {

    }
    public void processCancelOrderRequest() {
        order.cancelOrder();
        // then remove from receipt file

    }
}
