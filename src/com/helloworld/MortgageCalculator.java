package com.helloworld;

public class MortgageCalculator {
    private final static byte MONTHS_IN_YEAR = 12;
    private final static byte PERCENT = 100;
    private final int principal;
    private final float annualInterest;
    private final byte years;

    public MortgageCalculator(int principal, float annualInterestRate, byte years) {
        this.principal = principal;
        this.annualInterest = annualInterestRate;
        this.years = years;
    }

    public double calculateMortgage() {
        float monthlyInterest = getMonthlyInterest();
        short numberOfPayments = getNumberOfPayments();

        return principal * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments)) / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);
    }

    public double calculateBalance(
        short numberOfPaymentsMade
    ) {
        float monthlyInterest = getMonthlyInterest();
        short numberOfPayments = getNumberOfPayments();

        return principal
                * (Math.pow(1 + monthlyInterest, numberOfPayments) - Math.pow(1 + monthlyInterest, numberOfPaymentsMade))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);
    }

    private short getNumberOfPayments() {
        return (short) (years * 12);
    }

    private float getMonthlyInterest() {
        return annualInterest / PERCENT / MONTHS_IN_YEAR;
    }

    public double[] getRemainingBalances() {
        var balances = new double[getNumberOfPayments()];
        for (short month = 1; month <= getNumberOfPayments(); month ++)
            balances[month - 1] = calculateBalance(month);

        return balances;
    }
}
