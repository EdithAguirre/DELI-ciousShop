package com.pluralsight;

public abstract class Product {
    private int size;

    public Product(){}

    public Product(int size) {
        this.size = size;
    }
    public abstract double getPrice();

    public int getSize() {
        return size;
    }
}
