package com.pluralsight;

import java.util.List;

public class Sandwich extends Product{
    // Data fields
    private String breadType;
    private List<Topping> toppings;
    private boolean toasted;

    public Sandwich(double size, String breadType, List<Topping> toppings, boolean toasted) {
        super(size);
        this.breadType = breadType;
        this.toppings = toppings;
        this.toasted = toasted;
    }

    @Override
    public double getPrice(){
        return 0;
    }

    @Override
    public String toString(){
        return "";
    }

    public String getBreadType() {
        return breadType;
    }

    public void setBreadType(String breadType) {
        this.breadType = breadType;
    }

    public List<Topping> getToppings() {
        return toppings;
    }

    public void setToppings(List<Topping> toppings) {
        this.toppings = toppings;
    }

    public boolean isToasted() {
        return toasted;
    }

    public void setToasted(boolean toasted) {
        this.toasted = toasted;
    }
}
