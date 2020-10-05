package com.twu.refactoring;

public class NumberCruncher {
    private final int[] numbers;

    public NumberCruncher(int... numbers) {
        this.numbers = numbers;
    }

    public int countEven() {
        return countEvenAndOdd(0);
    }

    public int countOdd() {
        return countEvenAndOdd(1);
    }

    private int countEvenAndOdd(int i) {
        int count = 0;
        for (int number : numbers) {
            if (number % 2 == i) count++;
        }
        return count;
    }

    public int countPositive() {
        int count = 0;
        for (int number : numbers) {
            if (number >= 0) count++;
        }
        return count;
    }

    public int countNegative() {
        int count = 0;
        for (int number : numbers) {
            if (number < 0) count++;
        }
        return count;
    }

}
