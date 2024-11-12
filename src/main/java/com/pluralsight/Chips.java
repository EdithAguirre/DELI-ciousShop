package com.pluralsight;

public class Chips extends Product{
    private String type;

    public Chips(String type) {
        this.type = type;
    }

    @Override
    public double getPrice() {
        return 0;
    }
}
