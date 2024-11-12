package com.pluralsight;

public abstract class Product {

    private double size;

    public Product(){}
    public Product(double size) {
        this.size = size;
    }
    public abstract double getPrice();

    public double getSize() {
        return size;
    }


}
