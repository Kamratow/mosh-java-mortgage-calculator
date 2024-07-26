package com.helloworld;

import java.text.NumberFormat;
import java.util.Locale;

public class MortgageReport {
    public static void printMortgage(int principal, float annualInterestRate, byte years) {
        double mortgage = Main.calculateMortgage(principal, annualInterestRate, years);
        System.out.println();
        System.out.println("MORTGAGE");
        System.out.println("--------");
        System.out.println("Mortgage payments: " + NumberFormat.getCurrencyInstance(Locale.US)
                .format(mortgage));
    }

    public static void printPaymentSchedule(int principal, float annualInterestRate, byte years) {
        System.out.println();
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("----------------");
        float monthlyInterestRate = annualInterestRate / Main.PERCENT / Main.MONTHS_IN_YEAR;
        short numberOfPayments = (short) (years * 12);

        double currentBalance = principal;
        short numberOfPaymentsMade = 0;

        while (currentBalance > 0) {
            numberOfPaymentsMade++;
            currentBalance = principal
                    * (Math.pow(1 + monthlyInterestRate, numberOfPayments) - Math.pow(1 + monthlyInterestRate, numberOfPaymentsMade))
                    / (Math.pow(1 + monthlyInterestRate, numberOfPayments) - 1);
            System.out.println(NumberFormat.getCurrencyInstance(Locale.US).format(currentBalance));
        }
    }
}
