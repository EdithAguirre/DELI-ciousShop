package com.pluralsight;

public class Topping {

    private boolean premium, meat, extra;
    private String name;
    private double price;

    // Constructors (one with boolean meat, and one without)
    public Topping(boolean premium, String name, boolean extra) {
        this.premium = premium;
        this.name = name;
        this.extra = extra;
    }
    public Topping(boolean premium, String name, boolean extra, boolean meat) {
        this.premium = premium;
        this.name = name;
        this.extra = extra;
        this.meat = meat;
    }

    // Assigns and returns the price of a topping based on sandwich size
    public double getPrice(int size) {
        switch(size){
            case 4:
                this.price = loopPrices(1.00, 0.50, 0.75, 0.30);
                break;
            case 8:
                this.price = loopPrices(2.00, 1.00, 1.50, 0.60);
                break;
            case 12:
                this.price = loopPrices(3.00, 1.50, 2.25, 0.90);
                break;
        }
        return this.price;
    }

    // Determines total price of a premium topping considering if it is meat/cheese and/or added extra
    public double loopPrices(double meatPrice, double meatExtraPrice, double cheesePrice, double cheeseExtraPrice){
        double toppingPrice = 0;
        if(this.premium){ // premium
            if(this.meat){   // is meat
                toppingPrice += meatPrice;
                if(this.extra){  // extra meat
                    toppingPrice += meatExtraPrice;
                }
            }else{
                toppingPrice += cheesePrice;  // is cheese
                if(this.extra){    // extra cheese
                    toppingPrice += cheeseExtraPrice;
                }
            }
        }
        return toppingPrice;
    }

    // Getters and Setters
    public boolean isPremium() {
        return this.premium;
    }
    public void setPremium(boolean premium) {
        this.premium = premium;
    }
    public boolean isExtra() {
        return this.extra;
    }
    public void setExtra(boolean extra) {
        this.extra = extra;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public boolean isMeat() {
        return this.meat;
    }
    public void setMeat(boolean meat) {
        this.meat = meat;
    }
}
