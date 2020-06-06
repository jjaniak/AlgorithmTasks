import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringConverterTests {
    private StringConverter converter = new StringConverter();
    private List<String> list = new ArrayList<>();
    private static final String EMPTY = "";

// Write a method that will convert input list of strings into single String.

    @Test
    public void shouldConvertEmptyListToEmptyString() {
        String result = converter.convertListToSingleString(list);

        assertEquals(EMPTY, result);
    }

    @Test
    public void shouldConvertListWithEmptyWordsToEmptyString() {

    }

//    different Strings
//    UTF8 + ASCII  playing with special characters from different countries
//    when one String is null?  not to concatenate? or throw an exception?

}
