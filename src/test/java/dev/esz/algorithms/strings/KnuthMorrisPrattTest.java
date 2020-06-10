package dev.esz.algorithms.strings;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class KnuthMorrisPrattTest {

    @Test
    @DisplayName("should return true if second string is a substring of first one")
    void isMatchTest() {
        String a = "aefaefaefaedaefaedaefaefa";
        String b = "aefaedaefaefa";
        assertThat(KnuthMorrisPratt.isMatch(a, b)).isTrue();
    }

    @Test
    @DisplayName("should return false if second string is not a substring of first one")
    void isNoMatchTest() {
        String a = "aefaefaefaedaefaedaefaefg";
        String b = "aefaedaefaefa";
        assertThat(KnuthMorrisPratt.isMatch(a, b)).isFalse();
    }
}
