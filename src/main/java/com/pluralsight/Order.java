package com.pluralsight;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Order {
    // Data fields
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

    public void cancelOrder(){
        this.order.clear();
    }

    public double getTotalPrice() {
        double totalPrice = 0;
        for(Product product: order){
                totalPrice += product.getPrice();
            }
        return totalPrice;
    }

    public ArrayList<Product> getOrder() {
        return this.order;
    }

    public String getCustomerName() {
        return this.customerName;
    }

    public LocalDateTime getLocalDateTime() {
        return this.localDateTime;
    }

}
