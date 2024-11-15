package com.pluralsight;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Order {
    private String customerName;
    ArrayList<Product> order;
    LocalDateTime localDateTime;

    public Order(String customerName) {
        this.customerName = customerName;
        this.order = new ArrayList<>();
        this.localDateTime = LocalDateTime.now();
    }

    public void addProduct(Product product){
        this.order.add(product);
    }

    // Calculate total price of the order by adding prices of Sandwiches, Drinks, Chips
    public double getTotalPrice() {
        double totalPrice = 0;
        for(Product product: order){
                totalPrice += product.getPrice();
            }
        return totalPrice;
    }

    public void cancelOrder(){
        this.order.clear();
    }

    // Getters and Setters
    public ArrayList<Product> getOrder() {
        return this.order;
    }
    public String getCustomerName() {
        return this.customerName;
    }
    public LocalDateTime getLocalDateTime() {
        return this.localDateTime;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    public void setOrder(ArrayList<Product> order) {
        this.order = order;
    }
    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }
}
