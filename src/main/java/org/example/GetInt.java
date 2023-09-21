package org.example;

// A class responsible for taking input from a user.

import java.util.Scanner;

public class GetInt {
    public static int getInt() {
        Scanner sc = new Scanner(System.in);
        int number;
        do {
            while (!sc.hasNextInt()) {
                System.out.println("That's not a number! Try again!");
                sc.next();
            }
            number = sc.nextInt();
        } while (number < 0);
        return number;
    }
}