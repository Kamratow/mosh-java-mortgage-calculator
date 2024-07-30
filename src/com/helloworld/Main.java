package com.helloworld;

public class Main {

    public static void main(String[] args) {
        int principal;
        float annualInterestRate;
        byte years;

        principal = (int) Console.readNumber("Principal: ", 1000, 1_000_000);
        annualInterestRate = (float) Console.readNumber("Annual Interest Rate: ", 1, 30);
        years = (byte) Console.readNumber("Period (Years): ", 1, 30);

        var calculator = new MortgageCalculator(principal, annualInterestRate, years);
        var report = new MortgageReport(calculator);

        report.printMortgage();

        report.printPaymentSchedule();
    }

}