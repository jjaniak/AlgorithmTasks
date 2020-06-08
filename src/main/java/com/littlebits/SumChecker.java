package com.littlebits;

public class SumChecker {

    /**
     * checks if, given an int x and an array of ints y, any two numbers from y sum up to x
     *
     * @param x the sum value
     * @param numbers array of ints
     *
     * @return true if any two elements sum up to x; false otherwise.
     *  If numbers is null, is empty or it has only one character, it returns false
     */
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