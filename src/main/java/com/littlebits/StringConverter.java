package com.littlebits;

import java.util.List;

public class StringConverter {
    private String result = "";
//    private StringBuilder builder = new StringBuilder();

    public String convertListToSingleString(List<String> elements) throws IllegalArgumentException {
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