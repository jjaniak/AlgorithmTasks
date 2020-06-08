package com.littlebits;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SumCheckerTest {

    // should find the sum
    @Test
    public void addingTwoElementsSumTest() {
        int x = 7;
        int[] numbers = {3, 4};

        assertTrue(SumChecker.isThereSumWhenAddingTwoNumbersFromList(x, numbers));
    }

    @Test
    public void addingOppositeNumbersSummingToZeroTest() {
        int x = 0;
        int[] numbers = {593, -593};

        assertTrue(SumChecker.isThereSumWhenAddingTwoNumbersFromList(x, numbers));
    }

    @Test
    public void addingSumFromMultipleElementsTest() {
        int x = 2020;
        int[] numbers = {0, -2020, 15, 5, 2000, 2015};

        assertTrue(SumChecker.isThereSumWhenAddingTwoNumbersFromList(x, numbers));
    }

    @Test
    public void addingSumFromMultipleElementsInvolvingZeroTest() {
        int x = -19;
        int[] numbers = {-12, 7, -38, 0, 1, 5, 18, -19};

        assertTrue(SumChecker.isThereSumWhenAddingTwoNumbersFromList(x, numbers));
    }

    @Test
    public void findingTheSumEvenWithOverflowTest() {
        int x = 997;
        int[] numbers = {2147483647, 1, 900, 97};      // checks if overflow does not break the test

        assertTrue(SumChecker.isThereSumWhenAddingTwoNumbersFromList(x, numbers));
    }

    // should not find the sum
    @Test
    public void arrayIsNullTest() {
        int x = -37;
        int[] numbers = null;

        assertFalse(SumChecker.isThereSumWhenAddingTwoNumbersFromList(x, numbers));
    }

    @Test
    public void emptyArrayTest() {
        int x = 0;
        int[] numbers = {};

        assertFalse(SumChecker.isThereSumWhenAddingTwoNumbersFromList(x, numbers));
    }

    @Test
    public void oneElementInArrayTest() {
        int x = 42;
        int[] numbers = {42};

        assertFalse(SumChecker.isThereSumWhenAddingTwoNumbersFromList(x, numbers));
    }

    @Test
    public void addingTwoValuesNotGivingSumTest() {
        int x = 0;
        int[] numbers = {12, -8};

        assertFalse(SumChecker.isThereSumWhenAddingTwoNumbersFromList(x, numbers));
    }

    @Test
    public void addingValuesWhereOneElementIsSumTest() {
        int x = 2012;
        int[] numbers = {2012, -1, 1};

        assertFalse(SumChecker.isThereSumWhenAddingTwoNumbersFromList(x, numbers));
    }

    @Test
    public void addingVisuallySimilarValuesTest() {
        int x = -77;
        int[] numbers = {-7, 7, -7};

        assertFalse(SumChecker.isThereSumWhenAddingTwoNumbersFromList(x, numbers));
    }

    @Test
    public void needThreeValuesToGetSumTest() {
        int x = 264;
        int[] numbers = {6, 4, 2, 200, 60};

        assertFalse(SumChecker.isThereSumWhenAddingTwoNumbersFromList(x, numbers));
    }

    @Test
    @Disabled("handling overflow and underflow is not implemented in SumChecker")
    @DisplayName("Test checks if method can handle correctly underflow")
    public void handlingProperlyUnderflowTest() {
        int x = 2147483647;
        int[] numbers = {-2147483648, -1, 0};

        assertFalse(SumChecker.isThereSumWhenAddingTwoNumbersFromList(x, numbers));
    }
}