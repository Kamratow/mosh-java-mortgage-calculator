package com.helloworld;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Principal: ");
        int principal = scanner.nextInt();

        System.out.print("Annual Interest Rate: ");
        float annualInterestRate = scanner.nextFloat();
        float monthlyInterestRate = annualInterestRate/PERCENT/MONTHS_IN_YEAR;

        System.out.print("Period (Years): ");
        byte years = scanner.nextByte();
        int numberOfPayments = years * 12;

        String mortgage = NumberFormat.getCurrencyInstance(Locale.US)
                .format(principal * (monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numberOfPayments))/(Math.pow(1 + monthlyInterestRate, numberOfPayments) - 1));
        System.out.println("Mortgage: " + mortgage);

//        FizzBuzz exercise solution
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Number: ");
//        int number = scanner.nextInt();
//
//        if (number % 5 == 0 && number % 3 == 0) {
//            System.out.println("FizzBuzz");
//        } else if (number % 5 == 0) {
//            System.out.println("Fizz");
//        } else if (number % 3 == 0) {
//            System.out.println("Buzz");
//        } else {
//            System.out.println(number);
//        }

    }
}