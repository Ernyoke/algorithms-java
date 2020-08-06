package dev.esz.algorithms.misc;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MiscTest {

    @Test
    void oddNumberOfCharactersTest1() {
        int N = 4;
        assertThat(Misc.oddNumberOfCharacters(N)).isEqualTo("aaab");
    }

    @Test
    void oddNumberOfCharactersTest2() {
        int N = 3;
        assertThat(Misc.oddNumberOfCharacters(N)).isEqualTo("aaa");
    }

    @Test
    void oddNumberOfCharactersTest3() {
        int N = 0;
        assertThat(Misc.oddNumberOfCharacters(N)).isEqualTo("");
    }

    @Test
    void longestPeakTest() {
        int[] array = {1, 2, 3, 3, 4, 0, 10, 6, 5, -1, -3, 2, 3};
        assertThat(Misc.longestPeak(array)).isEqualTo(6);
    }

    @Test
    void longestPeakTest2() {
        int[] array = {1, 2, 3, 2, 1, 1};
        assertThat(Misc.longestPeak(array)).isEqualTo(5);
    }
}
