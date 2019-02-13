package com.company;

import java.text.ParseException;
import java.util.Scanner;

public class RestaurantPOS {
    public static void main(){
        double totalAmount = total();
        double totalWTax = totalAmount * 1.09;
        System.out.println("Your subtotal is $" + totalAmount + ". After tax, your total is $" + totalWTax + ". Would you like to add a tip?");
        double tipAmount = guiltTrip(totalWTax);
        double finalTotal = tipAmount + totalWTax;

        System.out.println("Your final total is $" + finalTotal);

        payment(finalTotal);

        System.out.println();
        System.out.println();



    }

    public static double total(){
        Scanner keyboard = new Scanner(System.in);
        double totalAmount;

        System.out.println("Please input your food and non-alcoholic drink total");
        double foodTotal;
        boolean execute = keyboard.hasNextDouble();
        if(execute==true)
            foodTotal=keyboard.nextDouble();
        else {
            while(execute ==false) {
                System.out.println("Please enter a valid amount");
                keyboard.next();
                execute = keyboard.hasNextDouble();

            }
            foodTotal = keyboard.nextDouble();
        }

        double alcoholTotal;
        System.out.println("Please enter your alcohol total");
        execute = keyboard.hasNextDouble();
        if(execute==true)
            alcoholTotal=keyboard.nextDouble();
        else {
            while(execute ==false) {
                System.out.println("Please enter a valid amount");
                keyboard.next();
                execute = keyboard.hasNextDouble();

            }
            alcoholTotal = keyboard.nextDouble();
        }

        totalAmount = foodTotal + alcoholTotal;

        return totalAmount;
    }

    public static double guiltTrip(Double totalAmount){
        Scanner keyboard2 = new Scanner(System.in);
        double tipAmount = 0;

        String giveTip = keyboard2.nextLine();
        boolean invalid = !giveTip.equalsIgnoreCase("Y") && !giveTip.equalsIgnoreCase("Yes") && !giveTip.equalsIgnoreCase("N") && !giveTip.equalsIgnoreCase("no");
        if(invalid == true){
            while (invalid == true) {
                System.out.println("Please enter a valid answer");
                giveTip = keyboard2.nextLine();
                invalid = !giveTip.equalsIgnoreCase("Y") && !giveTip.equalsIgnoreCase("Yes") && !giveTip.equalsIgnoreCase("N") && !giveTip.equalsIgnoreCase("no");
            }
            if (giveTip.equalsIgnoreCase("N") || giveTip.equalsIgnoreCase("No")) {
                System.out.println("Are you sure?");
                giveTip = keyboard2.nextLine();
                if (giveTip.equalsIgnoreCase("Y") || giveTip.equalsIgnoreCase("Yes"))
                    System.out.println("OK");
                else if (giveTip.equalsIgnoreCase("N") || giveTip.equalsIgnoreCase("No"))
                    tipAmount = giveTip(totalAmount);
            } else if (giveTip.equalsIgnoreCase("Y") || giveTip.equalsIgnoreCase("Yes")) {
                tipAmount = giveTip(totalAmount);
            }
        }
        else {
            if (giveTip.equalsIgnoreCase("N") || giveTip.equalsIgnoreCase("No")) {
                System.out.println("Are you sure?");
                giveTip = keyboard2.nextLine();
                if (giveTip.equalsIgnoreCase("Y") || giveTip.equalsIgnoreCase("Yes"))
                    System.out.println("OK");
                else if (giveTip.equalsIgnoreCase("N") || giveTip.equalsIgnoreCase("No"))
                    tipAmount = giveTip(totalAmount);
            } else if (giveTip.equalsIgnoreCase("Y") || giveTip.equalsIgnoreCase("Yes")) {
                tipAmount = giveTip(totalAmount);
            }
        }

        return tipAmount;
    }

    public static double giveTip(double totalAmount){
        Scanner keyboard3 = new Scanner(System.in);
        System.out.println("How much would you like to tip");
        System.out.println("Suggested Amounts: 15% - $" + (totalAmount * .15) + " || 20% - $" + (totalAmount * .20) + " || 25% $" + (totalAmount *.25));
        double userTip = 0;
        boolean execute = keyboard3.hasNextDouble();
        if(execute==true)
            userTip=keyboard3.nextDouble();
        else {
            while(execute ==false) {
                System.out.println("Please enter a valid amount");
                keyboard3.next();
                execute = keyboard3.hasNextDouble();
            }
            userTip = keyboard3.nextDouble();
        }
        return userTip;
    }

    public static void payment(double finalTotal){
        Scanner keyboard4 = new Scanner(System.in);

        System.out.println("Please type amount paid; if final total contains greater than 2 decimals, round to the next cent");
        double amtPaid=0;
        if(keyboard4.hasNextDouble()){
            amtPaid=keyboard4.nextDouble();
        }
        else{
            boolean invalid = false;
            while(invalid==false) {
                System.out.println("Please enter a valid amount");
                keyboard4.next();
                if (keyboard4.hasNextDouble()) {
                    amtPaid = keyboard4.nextDouble();
                    invalid=true;
                }
                else
                    invalid=false;
            }
        }
        if(amtPaid>finalTotal+.01){
            System.out.println("Your change is $" + (amtPaid - finalTotal));
            System.out.println("Thank you, come again");
        }
        else if(amtPaid<(finalTotal-.01)){
            while(amtPaid<(finalTotal-.01)){
                double amtOwed = finalTotal - amtPaid;
                System.out.println("You still owe $" + amtOwed);
                if(keyboard4.hasNextDouble()){
                    amtPaid = amtPaid+keyboard4.nextDouble();
                }
                else{
                    boolean invalid = false;
                    while(invalid==false) {
                        System.out.println("Please enter a valid amount");
                        keyboard4.next();
                        if (keyboard4.hasNextDouble()) {
                            amtOwed = keyboard4.nextDouble();
                            invalid=true;
                        }
                        else
                            invalid=false;
                    }
                }
            }
            System.out.println("Thank you, come again");
        }


    }


}
