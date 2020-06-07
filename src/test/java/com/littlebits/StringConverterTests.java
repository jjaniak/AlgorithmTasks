package com.littlebits;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringConverterTests {
    private final StringConverter converter = new StringConverter();
    private static final String EMPTY = "";

    @Test
    public void shouldConvertEmptyListToEmptyString() {
        String actualResult = converter.convertListToSingleString(new ArrayList<>());

        assertEquals(EMPTY, actualResult);
    }

    @Test
    public void shouldConvertListOfEmptyElementsToEmptyString() {
        String[] elements = {"", "", "", "", ""};
        String actualResult = converter.convertListToSingleString(Arrays.asList(elements));

        assertEquals(EMPTY, actualResult);
    }

    @Test
    public void shouldConvertListOfStringsToSingleString() {
        String[] elements = {"Mary ", "had", " a ", "little", "lamb", ".  "};
        final String expectedResult = "Mary had a littlelamb.  ";
        String actualResult = converter.convertListToSingleString(Arrays.asList(elements));

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void shouldConvertListOfSpecialCharStringsToSingleString() {
        List<String> list = List.of("ਬੀਟਲ", "على", "źdble", "сярод", "pcheł", "!"); // todo: List.of or Arrays.asList
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