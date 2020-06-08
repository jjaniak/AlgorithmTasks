package com.littlebits;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PalindromeCheckerTest {
    private final PalindromeChecker checker = new PalindromeChecker();

    @ParameterizedTest
    @DisplayName("Method isPalindrome() should return true given following words/sentences that are palindromes:")
    @CsvSource({
            "kayak",            // odd number of characters
            "0123443210",       // even number of characters
            "Madam",            // contains a capital letter
            "łamał",            // contains special characters
            "我爱妈妈，妈妈爱我",  // sentence-length palindrome in Chinese
            "Doc... note: I dissent! A fast never prevents a fatness. I diet on cod?"   // sentence containing spaces and punctuation
    })
    public void givenPalindromesShouldReturnTrue(String input) {
        assertTrue(checker.isPalindrome(input));
    }

    @ParameterizedTest
    @DisplayName("Method isPalindrome() should return false given following words/sentences that are not palindromes:")
    @CsvSource({
            "kayaak",           // odd number of characters
            "0123453210",       // even number of characters
            "Toyota",           // contains a capital letter
            "我爱妈妈妈妈爱",     // contains special characters
            "Go hang a salami; I am a lasagna hog!"     // sentence containing spaces and punctuation
    })
    public void givenNonPalindromesShouldReturnFalse(String input) {
        assertFalse(checker.isPalindrome(input));
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
        @DisplayName("given words containing similar letters (eg. \"e\" and \"è\" should assert false)")
        // In terms of palindrome, it was chosen to not consider "é" and "e" the same character
        public void twoSimilarCharactersShouldNotBeEquivalent() {
            String input = "È corta e non è sadica e non è acida se non è atroce";
            assertFalse(checker.isPalindrome(input));
        }
    }
}