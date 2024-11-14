package com.pluralsight;

import java.util.List;

public class Sandwich extends Product{
    // Data fields
    private String breadType, side, sauce;
    private List<Topping> toppings;
    private boolean toasted;

    public Sandwich(int size, String breadType, List<Topping> toppings, boolean toasted, String side, String sauce) {
        super(size);
        this.breadType = breadType;
        this.toppings = toppings;
        this.toasted = toasted;
        this.side = side;
        this.sauce = sauce;
    }

    @Override
    public double getPrice(){
        // size
        if(this.getSize() == 4){
            // bread + toppings price
            return this.getPriceOfBread() + this.getPriceOfToppings();
        } else if (this.getSize() == 8) {
            return this.getPriceOfBread() + this.getPriceOfToppings();
        } else {
            return this.getPriceOfBread() + this.getPriceOfToppings();
        }
    }

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

    @Override
    public String toString(){
        if(this.toasted) {
            return String.format("%d\" Sandwich " +
                    "\n   BREAD: %-16s TOASTED             $%.2f" +
                    "\n   TOPPINGS: " + toppingItemPriceString() +
                    "\n   SIDE: %s,   SAUCE: %s\n", this.getSize(), this.getBreadType(), this.getPriceOfBread(), this.side, this.sauce);
        }
        else{
            return String.format("%d\" Sandwich " +
                    "\n   BREAD: %-36s $%.2f" +
                    "\n   TOPPINGS: " + toppingItemPriceString() +
                    "\n   SIDE: %s SAUCE: %s\n", this.getSize(), this.getBreadType(), this.getPriceOfBread(), this.side, this.sauce);

        }
    }

    public String toppingItemPriceString() {
        String regularToppings = "\n   Regular:";
        String premiumToppings = "\n   Premium:";
        for (int i = 0; i < toppings.size(); i++) {
            if (!toppings.get(i).isPremium()) {
                if(i == 3 || i == 6 || i == 9){
                    regularToppings += "\n   ";
                }
                regularToppings += toppings.get(i).getName() + ", ";
            } else {
                premiumToppings += String.format("\n   %-43s $%.2f", toppings.get(i).getName(),
                        toppings.get(i).getPrice(this.getSize()));
            }
        }
        return regularToppings + premiumToppings;
    }

    public String getBreadType() {
        return this.breadType;
    }

    public void setBreadType(String breadType) {
        this.breadType = breadType;
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
