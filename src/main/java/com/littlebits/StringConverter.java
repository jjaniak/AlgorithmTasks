package com.littlebits;

import java.util.List;

public class StringConverter {
    private String result = "";
//    private StringBuilder builder = new StringBuilder();

    /**
     * converts a list of Strings to a new single String.
     * If any element on the list is null, then it is ignored and it is not concatenated to the final result.
     *
     * @param elements Strings to concatenate
     *
     * @throws IllegalArgumentException if elements is null
     *
     * @return a new concatenated String that includes all elements from the list
     */
    public String convertListToSingleString(List<String> elements) {
        if (elements == null) {
            throw new IllegalArgumentException("The List cannot be null");
        }
        for (String element : elements) {
            if (element == null) {
                continue;
            }
//            result = builder.append(element).toString();  // todo choose between StringBuilder, String.concat or + operator
            result = result.concat(element);    // or result += list.get(i);
        }
        return result;
    }
}