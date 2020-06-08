package com.littlebits;

public class SumChecker {

    public static boolean isThereSumWhenAddingTwoNumbersFromList(int x, int[] numbers) {
        if (numbers == null || numbers.length < 2) {
            return false;
        }

        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == x) {
                    return true;
                }
            }
        }
        return false;
    }
}