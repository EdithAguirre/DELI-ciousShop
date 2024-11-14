package com.pluralsight;

public class Chips extends Product{
    private String type;

    public Chips(String type) {
        this.type = type;
    }

    @Override
    public double getPrice() {
        return 1.50;
    }

    @Override
    public String toString() {
        return String.format("CHIPS: %-39s $%.2f\n", this.type, this.getPrice());
    }
}
