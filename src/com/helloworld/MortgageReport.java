package com.helloworld;

import java.text.NumberFormat;
import java.util.Locale;

public class MortgageReport {

    private final MortgageCalculator calculator;

    public MortgageReport(MortgageCalculator calculator) {
        this.calculator = calculator;
    }

    public void printMortgage() {
        double mortgage = calculator.calculateMortgage();
        System.out.println();
        System.out.println("MORTGAGE");
        System.out.println("--------");
        System.out.println("Mortgage payments: " + NumberFormat.getCurrencyInstance(Locale.US)
                .format(mortgage));
    }

    public void printPaymentSchedule() {
        System.out.println();
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("----------------");

        for (double balance: calculator.getRemainingBalances())
            System.out.println(NumberFormat.getCurrencyInstance(Locale.US).format(balance));
    }
}
