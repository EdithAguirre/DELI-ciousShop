package com.pluralsight;


import java.time.format.DateTimeFormatter;

public class Receipt {
    double salesTax = 0.0825;
    final String storeAddress = "123 Main St. Dallas, Tx. 74321";
    final String storePhoneNumber = "213-465-9870";
    DateTimeFormatter receiptDateFormat = DateTimeFormatter.ofPattern("MMM dd, yyyy, HH:mm a");
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

    public double getPriceWithTax(){
        return order.getTotalPrice() + (order.getTotalPrice() * salesTax);
    }

    public String getOrderInfo(){
        String orderInfo = String.format("""

                %-46s %s
                ======================================================
                """, " ITEM","PRICE");

        for (int i = order.getOrder().size() - 1; i >= 0; i--) {
            orderInfo += order.getOrder().get(i);
        }

        // Total price and other info
        orderInfo += String.format("\n %-48s%d\n %-45s $%.2f\n %-46s $%.2f\n %-45s $%.2f\n", "ITEM COUNT:",
                order.getOrder().size(),"SUBTOTAL:", this.order.getTotalPrice(), "TAX:",
                (order.getTotalPrice() * salesTax),"TOTAL:", getPriceWithTax());
        return orderInfo;
    }

    public String getReceiptHeader(){
        return """
                               DELI-cious Sandwich Shop
                            %s
                                     %s
                                %s
                                  %s
                """.formatted(this.storeAddress,this.storePhoneNumber, getReceiptDateTime(),"Order for " + order.getCustomerName());
    }

    public String getReceiptEnd(){
        return """

                ======================================================
                     Thank you for your order! Come again soon!""";
    }
}
