package com.helloworld;

import java.util.Scanner;

public class Console {
    private static final Scanner scanner = new Scanner(System.in);

    public static double readNumber(String prompt) {
        System.out.print(prompt);
        return scanner.nextDouble();
    }

    public static double readNumber(String prompt, double min, double max) {
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
}
