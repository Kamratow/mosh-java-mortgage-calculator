package com.helloworld;

import java.text.NumberFormat;
import java.util.Locale;

public class Main {
    final static byte MONTHS_IN_YEAR = 12;
    final static byte PERCENT = 100;

    public static void main(String[] args) {
        int principal;
        float annualInterestRate;
        byte years;

        principal = (int) Console.readNumber("Principal: ", 1000, 1_000_000);
        annualInterestRate = (float) Console.readNumber("Annual Interest Rate: ", 1, 30);
        years = (byte) Console.readNumber("Period (Years): ", 1, 30);

        printMortgage(principal, annualInterestRate, years);

        printPaymentSchedule(principal, annualInterestRate, years);
    }

    private static void printMortgage(int principal, float annualInterestRate, byte years) {
        double mortgage = calculateMortgage(principal, annualInterestRate, years);
        System.out.println();
        System.out.println("MORTGAGE");
        System.out.println("--------");
        System.out.println("Mortgage payments: " + NumberFormat.getCurrencyInstance(Locale.US)
                .format(mortgage));
    }

    private static void printPaymentSchedule(int principal, float annualInterestRate, byte years) {
        System.out.println();
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("----------------");
        showPaymentSchedule(principal, annualInterestRate, years);
    }

    public static void showPaymentSchedule(
            int principal,
            float annualInterestRate,
            short years) {
        float monthlyInterestRate = annualInterestRate/PERCENT/MONTHS_IN_YEAR;
        short numberOfPayments = (short)(years * 12);

        double currentBalance = principal;
        short numberOfPaymentsMade = 0;

        while(currentBalance > 0) {
            numberOfPaymentsMade++;
            currentBalance = principal
                    * (Math.pow(1 + monthlyInterestRate, numberOfPayments) - Math.pow(1 + monthlyInterestRate, numberOfPaymentsMade))
                    / (Math.pow(1 + monthlyInterestRate, numberOfPayments) - 1);
            System.out.println(NumberFormat.getCurrencyInstance(Locale.US).format(currentBalance));
        }
    }

    public static double calculateMortgage(
            int principal,
            float annualInterestRate,
            short years) {
        float monthlyInterestRate = annualInterestRate/PERCENT/MONTHS_IN_YEAR;
        short numberOfPayments = (short)(years * 12);

        return principal * (monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numberOfPayments))/(Math.pow(1 + monthlyInterestRate, numberOfPayments) - 1);
    }
}