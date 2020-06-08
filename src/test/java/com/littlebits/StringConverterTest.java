package com.littlebits;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringConverterTest {
    private final StringConverter converter = new StringConverter();
    private static final String EMPTY = "";

    @Test
    @DisplayName("Empty list should be converted to an empty String")
    public void shouldConvertEmptyListToEmptyString() {
        String actualResult = converter.convertListToSingleString(new ArrayList<>());

        assertEquals(EMPTY, actualResult);
    }

    @Test
    @DisplayName("List of empty Strings should be converted to an empty String")
    public void shouldConvertListOfEmptyElementsToEmptyString() {
        String[] elements = {"", "", "", "", ""};
        String actualResult = converter.convertListToSingleString(Arrays.asList(elements));

        assertEquals(EMPTY, actualResult);
    }

    @Test
    @DisplayName("List of Strings should be correctly converted to a single String")
    public void shouldConvertListOfStringsToSingleString() {
        String[] elements = {"Mary ", "had", " a ", "little", "lamb", ".  "};
        final String expectedResult = "Mary had a littlelamb.  ";
        String actualResult = converter.convertListToSingleString(Arrays.asList(elements));

        assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("List of Strings containing special characters should be correctly converted to a single String")
    public void shouldConvertListOfSpecialCharStringsToSingleString() {
        String[] elements = {"ਬੀਟਲ", "على", "źdble", "сярод", "pcheł", "!"};
        final String expectedResult = "ਬੀਟਲعلىźdbleсяродpcheł!";
        String actualResult = converter.convertListToSingleString(Arrays.asList(elements));

        assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("When some elements in the list are null, then null value should be ignored ")
    public void shouldIgnoreNullWhenConvertingToString() {
        String[] elements = {null, "Mary", "had", null, "little", null, "."};
        final String expectedResult = "Maryhadlittle.";
        String actualResult = converter.convertListToSingleString(Arrays.asList(elements));

        assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("When null is passed, then IllegalArgumentException exception should be thrown")
    public void shouldThrowIllegalArgumentExceptionWhenListIsNull() {
        Exception exception = assertThrows(IllegalArgumentException.class, ()-> converter.convertListToSingleString(null));
        assertEquals("The List cannot be null", exception.getMessage());
    }
}