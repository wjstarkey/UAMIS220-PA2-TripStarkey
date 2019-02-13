package com.company;

import java.util.Scanner;

public class CurrencyConverter {
    public static void main(){
        Scanner keyboard = new Scanner(System.in);
        String currency = currencyType();

        System.out.println("Type 1 if converting from the U.S. dollar, type 2 if converting to the U.S. Dollar");
        String toFrom = keyboard.nextLine();
        if(!toFrom.equals("1") && !toFrom.equals("2")){
            while(!toFrom.equals("1") && !toFrom.equals("2")){
                System.out.println("Please make a valid selection");
                toFrom=keyboard.nextLine();
            }
        }
        System.out.println("Please enter currency amount");
        String input = keyboard.nextLine();
        double amount = Double.parseDouble(input);
        if(toFrom.equals("1")){
            fromUS(currency, amount);
        }
        else{
            toUS(currency, amount);
        }

    }

    public static String currencyType(){
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Please select the currency you are using");
        System.out.println("(C)anadian Dollar");
        System.out.println("(E)uro");
        System.out.println("(I)ndian Rupee");
        System.out.println("(J)apanese Yen");
        System.out.println("(M)exican Peso");
        System.out.println("(B)ritish Pound");

        String currencyType = keyboard.nextLine();
        if(!currencyType.equalsIgnoreCase("C") && !currencyType.equalsIgnoreCase("E") && !currencyType.equalsIgnoreCase("I") && !currencyType.equalsIgnoreCase("J") && !currencyType.equalsIgnoreCase("M") && !currencyType.equalsIgnoreCase("B"))
        //ignore case added to add ease for user
        {
            while(!currencyType.equalsIgnoreCase("C") && !currencyType.equalsIgnoreCase("E") && !currencyType.equalsIgnoreCase("I") && !currencyType.equalsIgnoreCase("J") && !currencyType.equalsIgnoreCase("M") && !currencyType.equalsIgnoreCase("B")){
                System.out.println("Please input a valid selection");
                currencyType = keyboard.nextLine();
            }
        }

        return currencyType;
    }
    public static void toUS(String currency, double amount){
        double convertedCurrency = amount;


        if(currency.equalsIgnoreCase("C")) {
            convertedCurrency = amount / .9813;
        }
        else if(currency.equalsIgnoreCase("E")) {
            convertedCurrency = amount /.757;
        }
        else if(currency.equalsIgnoreCase("I")) {
            convertedCurrency = amount / 52.53;
        }
        else if(currency.equalsIgnoreCase("J")) {
            convertedCurrency = amount / 80.92;
        }
        else if(currency.equalsIgnoreCase("M")) {
            convertedCurrency = amount / 13.1544;
        }
        else if(currency.equalsIgnoreCase("B")) {
            convertedCurrency = amount / .6178;
        }


        System.out.println("Converted amount: $" + convertedCurrency + " USD");
    }
    public static void fromUS(String currency, double amount) {
        double convertedCurrency = amount;
        String type = "";

        if (currency.equalsIgnoreCase("C")) {
            convertedCurrency = amount * .9813;
            type = "Canadian Dollars";
        } else if (currency.equalsIgnoreCase("E")){
            convertedCurrency = amount * .757;
            type = "Euros";
        }
        else if(currency.equalsIgnoreCase("I")) {
            convertedCurrency = amount * 52.53;
            type="Indian Rupees";
        }
        else if(currency.equalsIgnoreCase("J")) {
            convertedCurrency = amount * 80.92;
            type="Japanese Yen";
        }
        else if(currency.equalsIgnoreCase("M")) {
            convertedCurrency = amount * 13.1544;
            type="Mexican Pesos";
        }
        else if(currency.equalsIgnoreCase("B")) {
            convertedCurrency = amount * .6178;
            type="British Pounds";
        }



        System.out.println("Converted amount: " + convertedCurrency + " " + type);
    }
}
