package com.littlebits;

public class PalindromeChecker {

    /**
     * checks if String input is a palindrome.
     * Punctuation and spaces are not taken into consideration when checking for palindromes.
     * Empty String (or String with only spaces or punctuation) is not considered a palindrome.
     *
     * @param input element to be assessed
     *
     * @return true if the input is a palindrome; false, otherwise. If the input is null, it returns false.
     */
    public boolean isPalindrome(String input) {
        if (input == null) {
            return false;
        }
        input = input.replaceAll("[\\p{Punct}\\s]","").toLowerCase();

        if (input.isEmpty()) {
            return false;
        }

        int length = input.length();
        int middle = length /2;
        for (int i = 0; i < middle; i++) {
            if (input.charAt(i) != input.charAt(length - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}