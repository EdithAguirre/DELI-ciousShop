package com.pluralsight;

public class Chips extends Product{
    private int type;

    public Chips(int type) {
        this.type = type;
    }

    // Implemented Product's abstract method to get price for a bag of chips
    @Override
    public double getPrice() {
        return 1.50;
    }

    // Overrides original toString method to format the output for a chips object
    @Override
    public String toString() {
        return String.format(" CHIPS: %-39s $%.2f\n", this.getType(), this.getPrice());
    }

    public String getType(){
        if(this.type == 1){
            return "Lay's";
        } else if (this.type == 2) {
            return "Doritos";
        } else if (this.type == 3) {
            return "Cheetos";
        }else{
            return "Takis";
        }
    }
}
