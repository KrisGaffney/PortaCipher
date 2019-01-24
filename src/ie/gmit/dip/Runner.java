package ie.gmit.dip;

import java.util.Scanner;
import java.io.*;
import java.net.*;


public class Runner {
    public static void main(String[] args) {
        //String key = "OBJECTORIENTATEDSOFTWAREDEVELOPMENT";
        String plainText = " ";

        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to the Porta Cipher. Enter a keyword...");
        String key = input.nextLine();

        System.out.println("Enter file location or a URL...");
        String plainTextLocation = input.nextLine();
        input.close();

        // if string is Url 
        if (plainTextLocation.contains(".") && (plainTextLocation.contains("http") || plainTextLocation.contains("https"))) {
            try {
                URL urlData = new URL(plainTextLocation);
                BufferedReader in = new BufferedReader(new InputStreamReader(urlData.openStream()));
                String inputLine = "";
                while ((inputLine = in.readLine()) != null) {
                    System.out.println(inputLine); 
                    plainText = plainText + inputLine;
                }

                in.close();

            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }


        } else { // if string is file path
            try {
                ReadFile file = new ReadFile(plainTextLocation);
                plainText = file.Read();

            } catch (IOException e) {
                System.out.println(e.getMessage() + "\n Ensure file \"" + plainTextLocation + "\" exists");
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }

        }

        // Do encryption 
        Porta cipher = new Porta(key);
        String cipherText = cipher.encrypt(plainText);
        System.out.println(cipherText);


    }


}
