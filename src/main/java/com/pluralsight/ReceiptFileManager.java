package com.pluralsight;

import java.io.*;

public class ReceiptFileManager {

    // Display receipt
//    public static void getReceipt(Receipt receipt){
//        receipt.getOrderInfo();
//    }

    // Save a receipt after customer confirms their order
    public static void saveReceipt(Receipt receipt){
        try{
            String filePath = receipt.getReceiptFileName() + ".txt";
            // Create receipt file
            File receiptFile = new File("C:src/main/resources/receiptsFolder/" + filePath);

            // Create bufWriter to write to the new receipt file
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/main/resources/receiptsFolder/" + filePath));
            bufferedWriter.write(receipt.getReceiptHeader());
            bufferedWriter.write(receipt.getOrderInfo());
            bufferedWriter.write(receipt.getReceiptEnd());

            bufferedWriter.close();
        }catch (IOException e){
            System.out.println("The receipt could not be saved to file.");
        }
    }
}
