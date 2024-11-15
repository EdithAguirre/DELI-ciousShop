package com.pluralsight;

import java.util.List;

public class Sandwich extends Product{
    // Data fields
    private String breadType, side, sauce;
    private List<Topping> toppings;
    private boolean toasted;

    public Sandwich(int size, String breadType, boolean toasted, List<Topping> toppings, String side, String sauce) {
        super(size);
        this.breadType = breadType;
        this.toasted = toasted;
        this.toppings = toppings;
        this.side = side;
        this.sauce = sauce;
    }

    // Implements Product's abstract method to get the price for a sandwich, toppings included
    @Override
    public double getPrice(){
        // size
        if(this.getSize() == 4){
            // bread price + toppings price
            return this.getPriceOfBread() + this.getPriceOfToppings();
        } else if (this.getSize() == 8) {
            return this.getPriceOfBread() + this.getPriceOfToppings();
        } else {
            return this.getPriceOfBread() + this.getPriceOfToppings();
        }
    }
    // Helper methods for getPrice (Calculates price of bread and all toppings for sandwich price)
    public double getPriceOfToppings(){
        double toppingsPrice = 0;
        for(Topping topping: toppings){
            toppingsPrice += topping.getPrice(this.getSize());
        }
        return  toppingsPrice;
    }

    public double getPriceOfBread(){
        if(this.getSize() == 4){
            return 5.50;
        } else if (this.getSize() == 8) {
            return 7.00;
        }else {
            return 8.50;
        }
    }

    //Overrides original toString method to format the output of a sandwich object
    @Override
    public String toString(){
        if(this.toasted) {
            return String.format(" %d\" Sandwich " +
                    "\n    BREAD: %-8s %-27s $%.2f" +
                    "\n    TOPPINGS: " + toppingsString() +
                    "\n    SIDE: %s,   SAUCE: %s\n", this.getSize(), this.getBreadType(),"(TOASTED)",
                    this.getPriceOfBread(), this.side, this.sauce);
        }
        else{
            return String.format(" %d\" Sandwich " +
                    "\n    BREAD: %-36s $%.2f" +
                    "\n    TOPPINGS: " + toppingsString() +
                    "\n    SIDE: %s SAUCE: %s\n", this.getSize(), this.getBreadType(), this.getPriceOfBread(),
                    this.side, this.sauce);

        }
    }
    // Helper method for the Sandwich toString method (Converts toppings list to string in a formatted way)
    public String toppingsString() {
        String regularToppings = "\n    Regular:";
        String premiumToppings = "\n    Premium:";
        for (int i = 0; i < toppings.size(); i++) {     // loop over toppings list
            if (!toppings.get(i).isPremium()) {     //regular toppings (not premium)
                if(i == 2 || i == 4 || i == 6 || i == 8){   // new line for every 2 items
                    regularToppings += "\n    ";
                }
                // save topping name and if added extra of topping include 'extra'
                regularToppings += (toppings.get(i).isExtra()) ?
                        toppings.get(i).getName() + " (EXTRA), "  : toppings.get(i).getName() + ", ";
            } else {    // premium toppings
                // save topping name, price, and if added extra of topping include 'extra'
                premiumToppings += (toppings.get(i).isExtra()) ?
                        String.format("\n     %-9s %-32s $%.2f", toppings.get(i).getName(),
                                "(EXTRA)",toppings.get(i).getPrice(this.getSize()))
                        : String.format("\n    %-43s $%.2f", toppings.get(i).getName(),
                                toppings.get(i).getPrice(this.getSize()));
            }
        }
        return regularToppings + premiumToppings;
    }

    // Getters and Setters
    public String getBreadType() {
        return this.breadType;
    }
    public void setBreadType(String breadType) {
        this.breadType = breadType;
    }
    public String getSide() {
        return this.side;
    }
    public void setSide(String side) {
        this.side = side;
    }
    public String getSauce() {
        return this.sauce;
    }
    public void setSauce(String sauce) {
        this.sauce = sauce;
    }
    public List<Topping> getToppings() {
        return this.toppings;
    }
    public void setToppings(List<Topping> toppings) {
        this.toppings = toppings;
    }
    public boolean isToasted() {
        return this.toasted;
    }
    public void setToasted(boolean toasted) {
        this.toasted = toasted;
    }
}
