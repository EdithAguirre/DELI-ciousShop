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
            return 5.50 + this.getPriceOfToppings();
        } else if (this.getSize() == 8) {
            return 7.00 + this.getPriceOfToppings();
        } else {
            return 8.50 + this.getPriceOfToppings();
        }
    }

    public double getPriceOfToppings(){
        double toppingsPrice = 0;
        switch (this.getSize()){
            case 4:
                loopOverToppingPrices(1.00, 0.50, 0.75, 0.30);
                break;
            case 8:
                loopOverToppingPrices(2.00, 1.00, 1.50, 0.60);
                break;
            case 12:
                loopOverToppingPrices(3.00, 1.50, 2.25, 0.90);
                break;
        }
        return toppingsPrice;
    }

    public double loopOverToppingPrices(double premiumMeat, double premiumMeatExtra, double premiumCheese, double premiumCheeseExtra){
        double toppingsPrice = 0;
        for(Topping topping : toppings){
            if(topping.isPremium()){ // premium
                if(topping.isMeat()){   // is meat
                    toppingsPrice += premiumMeat;
                    if(topping.isExtra()){  // extra meat
                        toppingsPrice += premiumMeatExtra;
                    }
                }else{
                    toppingsPrice += premiumCheese;  // is cheese
                    if(topping.isExtra()){    // extra cheese
                        toppingsPrice += premiumCheeseExtra;
                    }
                }
            }
        }
        return toppingsPrice;
    }

    @Override
    public String toString(){
        return "size: " + this.getSize() + ", Bread Type: " + this.breadType + ", Toppings..." +
                ", Toasted: " + this.toasted + ", Sides: " + this.side + ", Sauce: " + this.sauce;
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
