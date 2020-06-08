package com.littlebits;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SumCheckerTest {

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
        int[] numbers = {-12, 7, -38, 1, 18, 0, -19, 5};

        assertTrue(SumChecker.isThereSumWhenAddingTwoNumbers(x, numbers));
    }


    @Test
    public void isNotSumTest1() {
        int x = -37;
        int[] numbers = null;

        assertFalse(SumChecker.isThereSumWhenAddingTwoNumbers(x, numbers));
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
}