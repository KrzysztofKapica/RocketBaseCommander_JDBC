package org.example;

import java.util.Random;

public class ProbabilityOfHit {
    public boolean countProbabilityOfHit(int givenCityDistance, int givenRocketRange) {

        Random random = new Random();

        double result = (1 - ((double) givenCityDistance / (double) givenRocketRange)) * 100;
        int resultInt = (int) result;

        int randomNumber = random.nextInt(100);
        System.out.println("There's " + resultInt + "% of chance to hit the target.");
        System.out.println();

        wait(1000);
        System.out.print('.');
        wait(1000);
        System.out.print('.');
        wait(1000);
        System.out.print('.');
        wait(1000);
        System.out.println();

        return randomNumber <= resultInt;
    }

    public static void wait(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
}