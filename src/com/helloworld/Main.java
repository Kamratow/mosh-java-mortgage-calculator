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

        MortgageReport.printPaymentSchedule(years);
    }

}