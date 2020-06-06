package com.littlebits;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

//    UTF8 + ASCII  playing with special characters from different countries
//    when one String is null?  not to concatenate? or throw an exception?

}
