package com.pluralsight;

import java.util.ArrayList;

public class Order {
    // Data fields
    private String customerName;
    ArrayList<Product> order;
    private double totalPrice;

    public Order(String customerName) {
        this.customerName = customerName;
        this.order = new ArrayList<>();
    }

    public void addProduct(Product product){
        this.order.add(product);
    }

    public void cancelOrder(){
        this.order.clear();
    }


}
