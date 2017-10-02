package me.chrisp;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String creditCardNumber = "";

        // Ask for credit card number
        System.out.print("Enter your credit card number: ");
        // Get the next line instead of a long because I believe in both hyphenating every 4 digits or putting
        // a space between every 4 digits of a credit card number
        creditCardNumber = input.nextLine();

        /*
        System.out.print("Enter the full name listed on the front of the card: ");
        System.out.print("Enter the CVV for the credit card: ");
        System.out.print("Enter the expiration date for the credit card (MM/YY):");
        System.out.print("Enter your billing address: ");
        System.out.print("Enter your social security number: ");
        System.out.print("What is your mother's maiden name? ");
        System.out.print("What was the color of your first car? ");
        System.out.print("What was the name of your first pet? ");
        */

        CreditCard cc = new CreditCard(creditCardNumber);
        System.out.printf("%s is %s%n", creditCardNumber, cc.isValid() ? "valid" : "invalid");
    }
}
