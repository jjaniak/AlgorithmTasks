package com.littlebits;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SumCheckerTest {

    // should find the sum
    @Test
    public void isSumTest1() {
        int x = 7;
        int[] numbers = {3, 4};

        assertTrue(SumChecker.isThereSumWhenAddingTwoNumbers(x, numbers));
    }

    @Test
    public void isSumTest2() {
        int x = 0;
        int[] numbers = {593, -593};

        assertTrue(SumChecker.isThereSumWhenAddingTwoNumbers(x, numbers));
    }

    @Test
    public void isSumTest3() {
        int x = 2020;
        int[] numbers = {0, -2020, 15, 5, 2000, 2015};

        assertTrue(SumChecker.isThereSumWhenAddingTwoNumbers(x, numbers));
    }

    @Test
    public void isSumTest4() {
        int x = -19;
        int[] numbers = {-12, 7, -38, 0, 1, 5, 18, -19};

        assertTrue(SumChecker.isThereSumWhenAddingTwoNumbers(x, numbers));
    }

    @Test
    public void overflowShouldNotAffectFindingTheSum() {
        int x = 997;
        int[] numbers = {2147483647, 1, 900, 97};      // checks if overflow does not break the test

        assertTrue(SumChecker.isThereSumWhenAddingTwoNumbers(x, numbers));
    }

    // should not find the sum
    @Test
    public void isNotSumTest1() {
        int x = -37;
        int[] numbers = null;

        assertFalse(SumChecker.isThereSumWhenAddingTwoNumbers(x, numbers));  //todo why @Contract annotation?
    }

    @Test
    public void isNotSumTest2() {
        int x = 0;
        int[] numbers = {};

        assertFalse(SumChecker.isThereSumWhenAddingTwoNumbers(x, numbers));
    }

    @Test
    public void isNotSumTest3() {
        int x = 42;
        int[] numbers = {42};

        assertFalse(SumChecker.isThereSumWhenAddingTwoNumbers(x, numbers));
    }

    @Test
    public void isNotSumTest4() {
        int x = 0;
        int[] numbers = {12, -8};

        assertFalse(SumChecker.isThereSumWhenAddingTwoNumbers(x, numbers));
    }

    @Test
    public void isNotSumTest5() {
        int x = 2012;
        int[] numbers = {2012, -1, 1};

        assertFalse(SumChecker.isThereSumWhenAddingTwoNumbers(x, numbers));
    }

    @Test
    public void isNotSumTest6() {
        int x = -77;
        int[] numbers = {-7, 7, -7};

        assertFalse(SumChecker.isThereSumWhenAddingTwoNumbers(x, numbers));
    }

    @Test
    public void isNotSumTest7() {
        int x = 264;
        int[] numbers = {6, 4, 2, 200, 60};

        assertFalse(SumChecker.isThereSumWhenAddingTwoNumbers(x, numbers));
    }

    @Test
    @Disabled("handling overflow and underflow is not implemented in SumChecker")
    @DisplayName("Test checks if method can handle correctly underflow")
    public void shouldProperlyHandleUnderflowAndFail() {
        int x = 2147483647;
        int[] numbers = {-2147483648, -1, 0};

        assertFalse(SumChecker.isThereSumWhenAddingTwoNumbers(x, numbers));
    }
}