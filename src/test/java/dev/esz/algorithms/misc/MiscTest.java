package dev.esz.algorithms.misc;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MiscTest {

    @Test
    @DisplayName("should return a string where each character is present odd number of times")
    void oddNumberOfCharactersTest1() {
        int N = 4;
        assertThat(Misc.oddNumberOfCharacters(N)).isEqualTo("aaab");
    }

    @Test
    @DisplayName("should return a string where each character is present odd number of times")
    void oddNumberOfCharactersTest2() {
        int N = 3;
        assertThat(Misc.oddNumberOfCharacters(N)).isEqualTo("aaa");
    }

    @Test
    @DisplayName("should return an empty string if case of 0 input")
    void oddNumberOfCharactersTest3() {
        int N = 0;
        assertThat(Misc.oddNumberOfCharacters(N)).isEqualTo("");
    }

    @Test
    @DisplayName("should return a the size of the longest peak")
    void longestPeakTest() {
        int[] array = {1, 2, 3, 3, 4, 0, 10, 6, 5, -1, -3, 2, 3};
        assertThat(Misc.longestPeak(array)).isEqualTo(6);
    }

    @Test
    @DisplayName("should return a the size of the longest peak")
    void longestPeakTest2() {
        int[] array = {1, 2, 3, 2, 1, 1};
        assertThat(Misc.longestPeak(array)).isEqualTo(5);
    }
}
