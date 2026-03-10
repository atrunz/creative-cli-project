package org.codedifferently.helpers;

import java.util.Scanner;

public class InputHandler {

    public static int handleIntegerInput(Scanner scan) {
        while (true) {
            try {
                int input = Integer.parseInt(scan.nextLine());
                return input;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a whole number.");
            }
        }
    }

    public static double handleDoubleInput(Scanner scan) {
        while (true) {
            try {
                double input = Double.parseDouble(scan.nextLine());
                return input;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid number.");
            }
        }
    }

    public static String handleStringInput(Scanner scan) {
        while (true) {
            String input = scan.nextLine().trim();
            if (!input.isEmpty()) {
                return input;
            }
            System.out.println("Invalid input! Please enter a non-empty value.");
        }
    }
}