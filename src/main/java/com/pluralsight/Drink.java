package com.pluralsight;

public class Drink extends Product{
    private String flavor;

    public Drink(double price, double size, String flavor) {
        super(price, size);
        this.flavor = flavor;
    }
}
