package com.pluralsight;


import java.time.format.DateTimeFormatter;

public class Receipt {
    private final String storeAddress = "123 Main St. Dallas, Tx. 74321";
    private final String storePhoneNumber = "213-465-9870";
    DateTimeFormatter receiptDateFormat = DateTimeFormatter.ofPattern("MMM dd, YYYY, HH:mm a");
    DateTimeFormatter receiptFileNameFormat = DateTimeFormatter.ofPattern("yyyyMMdd-hhmmss");
    Order order;

    public Receipt(Order order){
        this.order = order;
    }

    public String getReceiptDateTime() {
        return this.order.getLocalDateTime().format(receiptDateFormat);
    }

    public String getReceiptFileName(){
        return this.order.getLocalDateTime().format(receiptFileNameFormat);
    }

    public String getOrderInfo(){
        return String.format("%37s\n%47s\n%31s\n%36s\n%35s\n%-35s %s\n %s" +
                        "------------------------------------------------------\n",
                "DELI-cious Sandwich Shop",this.storeAddress, this.storePhoneNumber,
                getReceiptDateTime(), "Order for " + order.getCustomerName(), "ITEM", "PRICE");
    }
}
