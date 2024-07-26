package com.helloworld;

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

        MortgageReport.printMortgage(principal, annualInterestRate, years);

        MortgageReport.printPaymentSchedule(principal, annualInterestRate, years);
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