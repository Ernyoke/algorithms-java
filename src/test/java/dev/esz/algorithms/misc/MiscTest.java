package dev.esz.algorithms.misc;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MiscTest {

    @Test
    void oddNumberOfCharactersTest1() {
        int N = 4;
        Misc misc = new Misc();
        assertThat(misc.oddNumberOfCharacters(N)).isEqualTo("aaab");
    }

    @Test
    void oddNumberOfCharactersTest2() {
        int N = 3;
        Misc misc = new Misc();
        assertThat(misc.oddNumberOfCharacters(N)).isEqualTo("aaa");
    }

    @Test
    void oddNumberOfCharactersTest3() {
        int N = 0;
        Misc misc = new Misc();
        assertThat(misc.oddNumberOfCharacters(N)).isEqualTo("");
    }
}
