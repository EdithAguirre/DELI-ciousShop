package com.pluralsight;

import java.util.ArrayList;

public class Order {
    // Data fields
    private String customerName;
    ArrayList<Product> order;

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

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public ArrayList<Product> getOrder() {
        return order;
    }

    public double getTotalPrice() {
        double totalPrice = 0;
        for(Product product: order){
                totalPrice += product.getPrice();
            }
        return totalPrice;
    }
}
