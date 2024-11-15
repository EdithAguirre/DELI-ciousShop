package com.pluralsight;

import java.io.*;

public class ReceiptFileManager {

    // Display receipt
    public static void getReceipt(Receipt receipt){
        try {
            String filePath = receipt.getReceiptFileName() + ".txt";
            BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/resources/receiptsFolder/" + filePath));

            String input;
            while((input = bufferedReader.readLine()) != null){
                System.out.println(input);
            }

        }catch (IOException e){
            System.out.println("The receipt could not be retrieved.");
        }
    }

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
