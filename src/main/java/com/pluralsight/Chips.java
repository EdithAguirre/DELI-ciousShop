package com.pluralsight;

public class Chips extends Product{
    private String type;

    public Chips(double price, double size, String type) {
        super(price, size);
        this.type = type;
    }
}
