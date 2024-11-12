package com.pluralsight;

public class Drink extends Product{
    private String flavor;

    public Drink(int size, String flavor) {
        super(size);
        this.flavor = flavor;
    }

    @Override
    public double getPrice(){
        if(this.getSize() == 1){
            return 2.00;
        } else if (this.getPrice() == 2) {
            return 2.50;
        } else{
            return 3.00;
        }
    }
}
