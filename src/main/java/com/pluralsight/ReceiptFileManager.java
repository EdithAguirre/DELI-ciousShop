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
    public static void saveReceipt(){
        try{

            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/main/resources/receiptsFolder"));




            bufferedWriter.close();
        }catch (IOException e){
            System.out.println("The receipt could not be saved to file.");
        }

    }

}
