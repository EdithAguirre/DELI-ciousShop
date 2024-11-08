package com.pluralsight;

import java.util.List;

public class Sandwich extends Product{
    // Data fields
    private int size;
    private String breadType;
    private List<Topping> toppings;
    private boolean toasted;


    public Sandwich(double price, double size, int size1, String breadType, List<Topping> toppings, boolean toasted) {
        super(price, size);
        this.size = size1;
        this.breadType = breadType;
        this.toppings = toppings;
        this.toasted = toasted;
    }

    

    @Override
    public String toString(){
        return "";
    }

}
