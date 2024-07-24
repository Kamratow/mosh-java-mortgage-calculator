package com.helloworld;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        Scanner scanner = new Scanner(System.in);
        int principal;
        float annualInterestRate;
        byte years;

        while(true) {
            System.out.print("Principal: ");
            principal = scanner.nextInt();

            if (principal >= 1000 && principal <= 1_000_000) {
                break;
            } else {
                System.out.println("Principal should be between $1K and $1M");
            }
        }

        while(true) {
            System.out.print("Annual Interest Rate: ");
            annualInterestRate = scanner.nextFloat();

            if (annualInterestRate >= 1 && annualInterestRate <= 30) {
                break;
            } else {
                System.out.println("Annual Interest Rate should be between 1 and 30");
            }
        }

        float monthlyInterestRate = annualInterestRate/PERCENT/MONTHS_IN_YEAR;

        while(true) {
            System.out.print("Period (Years): ");
            years = scanner.nextByte();

            if (years >= 1 && years <= 30) {
                break;
            } else {
                System.out.println("Period (Years) should be between 1 and 30");
            }
        }

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