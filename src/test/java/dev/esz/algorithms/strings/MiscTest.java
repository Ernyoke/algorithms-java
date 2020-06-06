package dev.esz.algorithms.strings;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MiscTest {

    @Test
    @DisplayName("should return true for a palindrome string with odd number of characters")
    void isPalindromeOddTest() {
        Assertions.assertThat(Misc.isPalindrome("abcba")).isTrue();
    }

    @Test
    @DisplayName("should return true for a palindrome string with odd number of characters")
    void isPalindromeEvenTest() {
        assertThat(Misc.isPalindrome("abba")).isTrue();
    }

    @Test
    @DisplayName("should return true for a string with one character")
    void isPalindromeOneCharTest() {
        assertThat(Misc.isPalindrome("a")).isTrue();
    }

    @Test
    @DisplayName("should return true for an empty string")
    void isPalindromeEmptyTest() {
        assertThat(Misc.isPalindrome("")).isTrue();
    }
}
