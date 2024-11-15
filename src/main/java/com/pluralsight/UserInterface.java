package com.pluralsight;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class UserInterface{
    Order order;
    Scanner scanner = new Scanner(System.in);

    public UserInterface() {}

    // Home Screen
    public void display() {
        while (true) {
            try {
                System.out.print("""
                        Welcome to DELI-cious Sandwich Shop!
                        ====================================
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
                        System.out.println("Thank you for your order! Come again soon!");
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
                // Display Order Screen
                System.out.print("""
                        Order Screen
                        ================
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
                        return;
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
        int size;
        while(true) {
            try {
                System.out.print("Sandwich size (4,8,12): ");
                size = scanner.nextInt();
                scanner.nextLine();
                if(size == 4 || size == 8 || size == 12){
                    break;
                }else{
                    System.out.println("Invalid selection. Please enter a valid option(4,8,12).\n");
                }
            }catch (InputMismatchException e){
                System.out.println("Invalid input. Please enter a numeric value.\n");
                scanner.nextLine();
            }
        }

        System.out.print("Select your bread- (1) White (2) Wheat (3) Rye (4) Wrap : ");
        String breadType = scanner.nextLine().trim();

        System.out.print("Would you like the sandwich toasted? (Y for Yes or N for No): ");
        boolean toasted = (scanner.nextLine().trim().equalsIgnoreCase("Y"));

        List<Topping> toppings = processAddToppingsRequest();   // prompt for toppings

        System.out.print("Which side would you like with your order? (au jus, sauce, or none): ");
        String side = scanner.nextLine();

        System.out.print("""
        Which sauce would you like to include with your order?
        (mayo, mustard, ketchup, ranch, thousand islands, vinaigrette, none)
        Enter the sauce: \
        """);
        String sauce = scanner.nextLine();
        order.addProduct(new Sandwich(size, breadType,toasted, toppings, side, sauce));
    }

    // Helper method for processAddSandwichRequest (helps display to user topping options: regular and premium)
    public List<Topping> processAddToppingsRequest() {
        List<Topping> tempToppings = new ArrayList<>();

        System.out.print("""
        Regular Toppings:(lettuce, peppers, onions, tomatoes, jalapeños, cucumbers,
        pickles, guacamole, mushrooms, or none)
        
        How many regular toppings would you like to add? (Enter 0 if none): \
        """);
        int regularToppingsCount = scanner.nextInt();
        scanner.nextLine();
        loopToAddToppings(tempToppings, regularToppingsCount, false, false);

        System.out.print("""
        Premium Toppings - Meats: (steak, ham, salami, roast beef, chicken, bacon, or none)
       
        Premium toppings come at an additional cost. How many premium meat toppings total would you like to add?
        (Enter 0 if none): \
        """);
        int meatToppingsCount = scanner.nextInt();
        scanner.nextLine();
        loopToAddToppings(tempToppings,meatToppingsCount,true,true);

        System.out.print("""
        Premium Toppings - Cheese: (american, provolone, cheddar, swiss, or none)
        
        Premium toppings come at an additional cost. How many premium cheese toppings total would you like to add?
        (Enter 0 if none): \
        """);
        int cheeseToppingsCount = scanner.nextInt();
        scanner.nextLine();
        loopToAddToppings(tempToppings,cheeseToppingsCount,true,false);

        return tempToppings;
    }

    // Helper method for processAddSandwichRequest (helps loop and add a number of toppings set by the user)
    public void loopToAddToppings(List<Topping> tempToppings, int toppingsCount, boolean premium, boolean meat){
        if(toppingsCount != 0) {
            for (int i = 0; i < toppingsCount; i++) {
                System.out.print("Enter a topping to add: ");
                String topping = scanner.nextLine().trim();
                System.out.print("Add extra?(Y for Yes or N for No): ");
                boolean extra = (scanner.nextLine().trim().equalsIgnoreCase("Y"));

                if (premium) {
                    tempToppings.add(new Topping(premium, topping, extra, meat));
                } else {
                    tempToppings.add(new Topping(premium, topping, extra));
                }
            }
        }
    }

    public void processAddDrinkRequest() {
        int drinkSize;
        int flavorChoice;
        String flavor;
        while (true){
            try {
                System.out.print("Select drink size - (1) Small  (2) Medium  (3) Large : ");
                drinkSize = scanner.nextInt();
                scanner.nextLine();
                if(drinkSize == 1 || drinkSize == 2 || drinkSize == 3) {
                    break;
                }else {
                    System.out.println("Invalid selection. Please enter a valid option(1,2,3).\n");
                }
            }catch (InputMismatchException e){
                System.out.println("Invalid input. Please enter a numeric value.\n");
                scanner.nextLine();
            }
        }
        while(true){
            try{
                System.out.print("Select flavor - (1) Sprite (2) Coke (3) Pepsi: ");
                flavorChoice = scanner.nextInt();
                scanner.nextLine();
                if(flavorChoice == 1) {
                    flavor = "Sprite";
                    break;
                } else if (flavorChoice == 2) {
                    flavor = "Coke";
                    break;
                } else if (flavorChoice == 3) {
                    flavor = "Pepsi";
                    break;
                } else {
                    System.out.println("Invalid selection. Please enter a valid option(1,2,3).\n");
                }
            }catch (InputMismatchException e){
                System.out.println("Invalid input. Please enter a numeric value.\n");
                scanner.nextLine();
            }
        }
        order.addProduct(new Drink(drinkSize,flavor));
    }

    public void processAddChipsRequest() {
        int chipType;
        while(true){
            try{
                System.out.print("Select chip type- (1) Lay's (2) Doritos (3) Cheetos (4) Takis: ");
                chipType = scanner.nextInt();
                scanner.nextLine();
                if(chipType == 1 ||chipType == 2 ||chipType == 3 || chipType == 4) {
                    order.addProduct(new Chips(chipType));
                    break;
                }else{
                    System.out.println("Invalid selection. Please enter a valid option(1,2,3,4).\n");
                }
            }catch (InputMismatchException e){
                System.out.println("Invalid input. Please enter a numeric value.\n");
                scanner.nextLine();
            }
        }
    }

    public void processCheckOutRequest() {
        System.out.println("Here are the details and price for your order: ");

        while(true) {
            // call method to display order details and the price
            Receipt receipt = new Receipt(order);
            System.out.println(receipt.getOrderInfo());

            System.out.print("""
                    1) Confirm
                    0) Cancel Order
                    Enter your choice: \
                    """);
            int choice = scanner.nextInt();
            System.out.println();
            switch(choice) {
                case 1:
                    // Save receipt file and go back to home screen
                    ReceiptFileManager.saveReceipt(receipt);
                    return;
                case 0:
                    // Cancel order and return to home screen
                    order.cancelOrder();
                    return;
                default:
                    System.out.println("Invalid input. Please enter a valid choice (1 or 0).");
                    scanner.nextLine();
                    break;
                }
            }
        }

    public void processCancelOrderRequest() {
        // deletes the order
        order.cancelOrder();
    }

}
