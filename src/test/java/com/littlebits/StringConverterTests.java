package com.littlebits;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringConverterTests {
    private StringConverter converter = new StringConverter();
    private List<String> list = new ArrayList<>();
    private static final String EMPTY = "";

// Write a method that will convert input list of strings into single String.
// BeforeEach ?  - make sure the list is empty before each test

    @Test
    public void shouldConvertEmptyListToEmptyString() {
        String actualResult = converter.convertListToSingleString(list);

        assertEquals(EMPTY, actualResult);
    }

    @Test
    public void shouldConvertListOfEmptyElementsToEmptyString() {
        String[] elements = {"", "", "", "", ""};
        list.addAll(Arrays.asList(elements) );
        String actualResult = converter.convertListToSingleString(list);

        assertEquals(EMPTY, actualResult);
    }

    @Test
    public void shouldConvertListOfStringsToSingleString() {
        String expectedResult = "Maryhadalittlelamb";
        String[] elements = {"Mary", "had", "a", "little", "lamb", "."};
        list.addAll(Arrays.asList(elements) );

        // or
        // list = List.of("Mary", "had", "a", "little", "lamb", ".");

        String actualResult = converter.convertListToSingleString(list);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void shouldConvertListOfSpecialCharStringsToSingleString() {
        list = List.of("ਬੀਟਲ", "على", "źdble", "сярод", "pcheł", "!");
        final String expectedResult = "ਬੀਟਲعلىźdbleсяродpcheł!";
        String actualResult = converter.convertListToSingleString(list);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("Test checks if null value is ignored when some elements in the list are null")
    public void shouldIgnoreNullWhenConvertingToString() {
        String[] elements = {null, "Mary", "had", null, "little", null, "."};
        final String expectedResult = "Maryhadlittle.";
        String actualResult = converter.convertListToSingleString(Arrays.asList(elements));

        assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("When null is passed IllegalArgumentException exception should be thrown")
    public void shouldThrowIllegalArgumentExceptionWhenListIsNull() {
        Exception exception = assertThrows(IllegalArgumentException.class, ()-> converter.convertListToSingleString(null));
        assertEquals("The List cannot be null", exception.getMessage());
    }
}