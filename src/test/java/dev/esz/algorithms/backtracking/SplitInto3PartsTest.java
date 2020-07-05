package dev.esz.algorithms.backtracking;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SplitInto3PartsTest {

    @Test
    @DisplayName("should return the correct number of solutions")
    void solution1Test() {
        String A = "babaab";
        SplitInto3Parts splitInto3Parts = new SplitInto3Parts();
        assertThat(splitInto3Parts.solution(A)).isEqualTo(2);
    }

    @Test
    @DisplayName("should return the correct number of solutions")
    void solution2Test() {
        String A = "ababa";
        SplitInto3Parts splitInto3Parts = new SplitInto3Parts();
        assertThat(splitInto3Parts.solution(A)).isEqualTo(4);
    }


    @Test
    @DisplayName("should return the correct number of solutions")
    void solution3Test() {
        String A = "bbbbb";
        SplitInto3Parts splitInto3Parts = new SplitInto3Parts();
        assertThat(splitInto3Parts.solution(A)).isEqualTo(6);
    }

    @Test
    @DisplayName("should return the correct number of solutions")
    void solution4Test() {
        String A = "aabaaaa";
        SplitInto3Parts splitInto3Parts = new SplitInto3Parts();
        assertThat(splitInto3Parts.solution(A)).isEqualTo(2);
    }

    @Test
    @DisplayName("should return the correct number of solutions")
    void solution5Test() {
        String A = "abbab";
        SplitInto3Parts splitInto3Parts = new SplitInto3Parts();
        assertThat(splitInto3Parts.solution(A)).isEqualTo(0);
    }

    @Test
    @DisplayName("should return the correct number of solutions")
    void solution6Test() {
        String A = "ababa";
        SplitInto3Parts splitInto3Parts = new SplitInto3Parts();
        assertThat(splitInto3Parts.solution(A)).isEqualTo(4);
    }
}
