package com.littlebits;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PalindromeCheckerTests {
    private final PalindromeChecker checker = new PalindromeChecker();

    @Nested
    @DisplayName("Method isPalindrome() should return true")
    public class ActualPalindromeTests {
        private final String palindrome1 = "kayak";
        private final String palindrome2 = "0123443210";
        private final String palindrome3 = "Madam";
        private final String palindrome4 = "łamał";
        private final String palindrome5 = "Doc, note: I dissent! A fast never prevents a fatness. I diet on cod?";
        private final String palindrome6 = "我爱妈妈，妈妈爱我";

        @Test
        @DisplayName("given a palindrome with odd number of characters")
        public void givenOddPalindromeShouldReturnTrue() {
            assertTrue(checker.isPalindrome(palindrome1));
        }

        @Test
        @DisplayName("given a palindrome with even number of characters")
        public void givenEvenPalindromeShouldReturnTrue() {
            assertTrue(checker.isPalindrome(palindrome2));
        }

        @Test
        @DisplayName("given a palindrome containing a capital letter")
        public void givenPalindromeWithCapitalLetterShouldReturnTrue() {
            assertTrue(checker.isPalindrome(palindrome3));
        }

        @Test
        @DisplayName("given a palindrome containing special characters")
        public void givenPalindromeWithSpecialCharShouldReturnTrue() {
            assertTrue(checker.isPalindrome(palindrome4));
        }

        @Test
        @DisplayName("given a sentence-length palindrome containing spaces and punctuation")
        public void givenSentencePalindromeWithSpacesAndPunctuationShouldReturnTrue() {
            assertTrue(checker.isPalindrome(palindrome5));
        }

        @Test
        @DisplayName("given a sentence-length palindrome in Chinese")
        public void givenSentenceLengthPalindromeInChineseShouldReturnTrue() {
            assertTrue(checker.isPalindrome(palindrome6));
        }
    }

    @Nested
    @DisplayName("Method isPalindrome() should return false")
    public class NotPalindromeTests {
        private final String notPalindrome1 = "kayaak";
        private final String notPalindrome2 = "0123453210";
        private final String notPalindrome3 = "Toyota";
        private final String notPalindrome4 = "我爱妈妈妈妈爱";
        private final String notPalindrome5 = "Go hang a salami, I am a lasagna hog!";

        @Test
        @DisplayName("given a non palindrome with odd number of characters")
        public void givenNonPalindromeWithOddNumberofCharShouldReturnFalse() {
            assertFalse(checker.isPalindrome(notPalindrome1));
        }

        @Test
        @DisplayName("given a non palindrome with even number of characters")
        public void givenNonPalindromeWithEvenNumberofCharShouldReturnFalse() {
            assertFalse(checker.isPalindrome(notPalindrome2));
        }

        @Test
        @DisplayName("given a non palindrome containing a capital letter")
        public void givenNonPalindromeWithCapitalLetterShouldReturnFalse() {
            assertFalse(checker.isPalindrome(notPalindrome3));
        }

        @Test
        @DisplayName("given a non palindrome containing special characters")
        public void givenNonPalindromeWithSpecialCharsShouldReturnFalse() {
            assertFalse(checker.isPalindrome(notPalindrome4));
        }

        @Test
        @DisplayName("given a sentence (not a palindrome) containing spaces and punctuation")
        public void givenSentenceNonPalindromeWithSpacesAndPunctuationShouldReturnFalse() {
            assertFalse(checker.isPalindrome(notPalindrome5));
        }
    }

    @Nested
    @DisplayName("Tricky situations:")
    public class EdgeCasesPalindromeTests {

        @Test
        @DisplayName("given null should assert false")
        public void nullShouldNotBePalindrome() {
            assertFalse(checker.isPalindrome(null));
        }

        @Test
        @DisplayName("given empty String should assert false")
        public void emptyStringShouldNotBePalindrome() {
            assertFalse(checker.isPalindrome(""));
        }

        @Test
        @DisplayName("given String with only spaces should assert false")
        public void onlySpacesStringShouldNotBePalindrome() {
            assertFalse(checker.isPalindrome("       "));
        }

        @Test
        @DisplayName("given String with punctuation only should assert false")
        public void onlyPunctuationStringShouldNotBePalindrome() {
            assertFalse(checker.isPalindrome("(!%$%!)"));
        }

        @Test
        @DisplayName("given one character String should assert true")
        public void oneCharacterStringShouldBePalindrome() {
            assertTrue(checker.isPalindrome("e"));
        }

        @Test
        @DisplayName("given one UTF8 character String should assert true")
        public void oneCharacterUTF8StringShouldBePalindrome() {
            assertTrue(checker.isPalindrome("ą"));
        }

        @Test
        @DisplayName("given words containing similar letters (eg. \"e\" and \"è\" should assert false")
        // In terms of palindrome it was chosen to not consider "é" and "e" the same character
        public void twoSimilarCharactersShouldNotBeEquivalent() {
            String input = "È corta e non è sadica e non è acida se non è atroce";
            assertFalse(checker.isPalindrome(input));
        }
    }
}