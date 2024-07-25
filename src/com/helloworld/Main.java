package com.helloworld;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int principal;
        float annualInterestRate;
        byte years;

        principal = (int)readNumber("Principal: ", 1000, 1_000_000);
        annualInterestRate = (float)readNumber("Annual Interest Rate: ", 1, 30);
        years = (byte)readNumber("Period (Years): ", 1, 30);

        System.out.println("Mortgage: " + calculateMortgage(principal, annualInterestRate, years));
    }

    public static double readNumber(String prompt, double min, double max) {
        Scanner scanner = new Scanner(System.in);
        double value;

        while (true) {
            System.out.print(prompt);

            value = scanner.nextDouble();

            if (value >= min && value <= max) {
                break;
            } else {
                System.out.println("Enter value between " + min + " and " + max);
            }
        }

        return value;
    }

    public static String calculateMortgage(
            int principal,
            float annualInterestRate,
            short years) {
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        float monthlyInterestRate = annualInterestRate/PERCENT/MONTHS_IN_YEAR;
        short numberOfPayments = (short)(years * 12);

        return NumberFormat.getCurrencyInstance(Locale.US)
                .format(principal * (monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numberOfPayments))/(Math.pow(1 + monthlyInterestRate, numberOfPayments) - 1));
    }
}