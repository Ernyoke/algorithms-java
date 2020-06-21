package dev.esz.algorithms.strings;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

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

    @Test
    @DisplayName("should return the histogram of the letters of a string")
    void histogramTest() {
        Map<Character, Integer> histogram = Misc.histogram("abbbaccdddd");
        Map<Character, Integer> expected = Map.of('a', 2, 'b', 3, 'c', 2, 'd', 4);
        assertThat(histogram).containsExactlyInAnyOrderEntriesOf(expected);
    }

    @Test
    @DisplayName("should return true in case if b is an anagram of a")
    void isAnagramTest() {
        String a = "aaabb";
        String b = "baaba";
        assertThat(Misc.isAnagram(a, b)).isTrue();
    }

    @Test
    @DisplayName("should return false in case if b is not an anagram of a")
    void isNotAnagramTest() {
        String a = "aaabb";
        String b = "baba";
        assertThat(Misc.isAnagram(a, b)).isFalse();
    }

    @Test
    @DisplayName("should return false in case if b is not an anagram of a")
    void isNotAnagram2Test() {
        String a = "aaabb";
        String b = "bcaba";
        assertThat(Misc.isAnagram(a, b)).isFalse();
    }

    @Test
    @DisplayName("should group anagrams")
    void groupAnagramsTest() {
        List<String> strings = List.of("aba", "ba", "baa", "caca", "acca", "abc");
        List<List<String>> expected = List.of(List.of("ba"), List.of("aba", "baa"), List.of("caca", "acca"), List.of("abc"));
        List<List<String>> actual = Misc.groupAnagrams(strings);
        assertThat(actual.size()).isEqualTo(expected.size());
        for (var list : expected) {
            assertThat(actual.stream().anyMatch(item -> item.containsAll(list))).isTrue();
        }
    }

    @Test
    @DisplayName("should group anagrams")
    void groupAnagrams2Test() {
        List<String> strings = List.of("yo", "act", "flop", "tac", "cat", "oy", "olfp");
        List<List<String>> expected = List.of(List.of("flop", "olfp"), List.of("oy", "yo"), List.of("act", "cat", "tac"));
        List<List<String>> actual = Misc.groupAnagrams(strings);
        System.out.println(actual);
        assertThat(actual.size()).isEqualTo(expected.size());
        for (var list : expected) {
            assertThat(actual.stream().anyMatch(item -> item.containsAll(list))).isTrue();
        }
    }
}
