package com.pluralsight;

import java.io.*;

public class ReceiptFileManager {

    public static Receipt getReceipt(){
        Receipt receipt = null;
        try{
            BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/resources"));




        }catch (IOException e){
            e.printStackTrace();
        }



        return receipt;
    }

    // save a receipt after customer confirms their order
    public static void saveReceipt(Receipt receipt){
        try{
            String filePath = receipt.getReceiptFileName() + ".txt";
            // Create receipt file
            File receiptFile = new File("C:src/main/resources/receiptsFolder/" + filePath);

            // Create bufWriter to write to the new receipt file
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/main/resources/receiptsFolder/" + filePath));
            bufferedWriter.write(receipt.getOrderInfo());

            bufferedWriter.close();
        }catch (IOException e){
            System.out.println("The receipt could not be saved to file.");
        }
    }
}
