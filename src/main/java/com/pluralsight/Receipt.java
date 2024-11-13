package com.pluralsight;

import java.time.LocalDateTime;

public class Receipt {
    private String storeAddress;
    private String storePhoneNumber;
    private String customerName;
    private int quantityOfItems;
    private double itemPrice, totalPrice;
    private LocalDateTime localDateTime;


    public Receipt(String storeAddress, String storePhoneNumber, String customerName, int quantityOfItems, double itemPrice, double totalPrice, LocalDateTime localDateTime) {
        this.storeAddress = storeAddress;
        this.storePhoneNumber = storePhoneNumber;
        this.customerName = customerName;
        this.quantityOfItems = quantityOfItems;
        this.itemPrice = itemPrice;
        this.totalPrice = totalPrice;
        this.localDateTime = localDateTime;
    }




}
