package com.pluralsight;

public abstract class Product {
    private int size;

    // Constructors
    public Product(){}
    public Product(int size) {
        this.size = size;
    }

    // Abstract method
    public abstract double getPrice();

    // Getter for size
    public int getSize() {
        return size;
    }
}
