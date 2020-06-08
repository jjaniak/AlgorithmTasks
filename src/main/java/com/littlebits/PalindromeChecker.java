package com.littlebits;

public class PalindromeChecker {

    public boolean isPalindrome(String input) {
        if (input == null) {
            return false;
        }
        // punctuation and spaces are ignored when checking for palindromes
        input = input.replaceAll("[\\p{Punct}\\s]","").toLowerCase();

        // empty String (or String with only spaces or punctuation) is not considered a palindrome
        if (input.isEmpty()) {
            return false;
        }

        int length = input.length();
        for (int i = 0; i < length /2; i++) {
            if (input.charAt(i) != input.charAt(length - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}