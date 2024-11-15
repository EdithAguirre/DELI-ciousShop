package com.pluralsight;

public class Drink extends Product{
    private String flavor;

    public Drink(int size, String flavor) {
        super(size);
        this.flavor = flavor;
    }

    // Implemented Product's abstract method to get price of a drink
    @Override
    public double getPrice(){
        if(this.getSize() == 1){
            return 2.00;
        } else if (this.getSize() == 2) {
            return 2.50;
        } else {
            return 3.00;
        }
    }

    // Returns drink size as a string
    public String getStringSize(){
        if(this.getSize() == 1){
            return "SMALL";
        } else if (this.getSize() ==2) {
            return  "MEDIUM";
        } else {
            return "LARGE";
        }
    }

    // Overrides original toString method to format the output for a drink object
    @Override
    public String toString() {
        return String.format(" DRINK: %-10s Size:%-23s $%.2f\n", this.flavor,getStringSize(), this.getPrice());
    }
}
