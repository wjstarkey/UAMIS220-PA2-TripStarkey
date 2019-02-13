package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String menuResponse = menu();
	    while(!menuResponse.equals("3")) {
            if (menuResponse.equals("1")) {
                CurrencyConverter.main();

                System.out.println();
                System.out.println();
                menuResponse = menu();
            }
            else if (menuResponse.equals("2")) {
                RestaurantPOS.main();

                System.out.println();
                System.out.println();
                menuResponse = menu();
            }
            else
                System.out.println("Exit");

        }

    }

    public static String menu(){
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Please select from the options below:");
        System.out.println("1) Convert Currencies");
        System.out.println("2) Restaurant POS");
        System.out.println("3) Exit");

        String menuResponse = keyboard.nextLine();
        if(!menuResponse.equals("1") && !menuResponse.equals("2") && !menuResponse.equals("3"))
        {
            while(!menuResponse.equals("1") && !menuResponse.equals("2") && !menuResponse.equals("3")){
                System.out.println("Please input a valid selection");
                System.out.println("1) Convert Currencies");
                System.out.println("2) Restaurant POS");
                System.out.println("3) Exit");
                menuResponse = keyboard.nextLine();
            }
        }
        return menuResponse;
    }
}
