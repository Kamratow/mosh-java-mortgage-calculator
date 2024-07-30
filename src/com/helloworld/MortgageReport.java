package com.helloworld;

import java.text.NumberFormat;
import java.util.Locale;

public class MortgageReport {

    private static MortgageCalculator calculator;

    public static void printMortgage(int principal, float annualInterestRate, byte years) {
        calculator = new MortgageCalculator(principal, annualInterestRate, years);
        double mortgage = calculator.calculateMortgage();
        System.out.println();
        System.out.println("MORTGAGE");
        System.out.println("--------");
        System.out.println("Mortgage payments: " + NumberFormat.getCurrencyInstance(Locale.US)
                .format(mortgage));
    }

    public static void printPaymentSchedule(byte years) {
        System.out.println();
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("----------------");

        for (short month = 1; month <= years * Main.MONTHS_IN_YEAR; month ++) {
            double balance = calculator.calculateBalance(month);
            System.out.println(NumberFormat.getCurrencyInstance(Locale.US).format(balance));
        }
    }
}
