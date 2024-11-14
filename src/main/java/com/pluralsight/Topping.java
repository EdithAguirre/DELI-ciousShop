package com.pluralsight;

public class Topping {

    private boolean premium, meat, extra;
    private String name;
    private double price;

    public Topping(boolean premium, String name) {
        this.premium = premium;
        this.name = name;
    }
    public Topping(boolean premium, String name, boolean extra, boolean meat) {
        this.premium = premium;
        this.name = name;
        this.extra = extra;
        this.meat = meat;
    }

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
            default:
        }
        return this.price;
    }

    public double loopPrices(double premiumMeat, double premiumMeatExtra, double premiumCheese, double premiumCheeseExtra){
        double toppingPrice = 0;
        if(this.premium){ // premium
            if(this.meat){   // is meat
                toppingPrice += premiumMeat;
                if(this.extra){  // extra meat
                    toppingPrice += premiumMeatExtra;
                }
            }else{
                toppingPrice += premiumCheese;  // is cheese
                if(this.extra){    // extra cheese
                    toppingPrice += premiumCheeseExtra;
                }
            }
        }
        return toppingPrice;
    }

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
