package com.pluralsight;

public class Drink extends Product{
    private String flavor;

    public Drink(double size, String flavor) {
        super(size);
        this.flavor = flavor;
    }

    @Override
    public double getPrice(){
        return 0;
    }
}
