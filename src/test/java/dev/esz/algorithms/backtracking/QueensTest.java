package dev.esz.algorithms.backtracking;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class QueensTest {
    @Test
    @DisplayName("should solve queens problem for 4 queens")
    void solve4QueensRecursiveTest() {
        var solutions = Queens.solveRecursive(4);
        assertThat(solutions.size()).isEqualTo(2);
        assertThat(solutions.get(0)).containsExactly(1, 3, 0, 2);
        assertThat(solutions.get(1)).containsExactly(2, 0, 3, 1);
    }

    @Test
    @DisplayName("should solve queens problem for 5 queens")
    void solve5QueensRecursiveTest() {
        var solutions = Queens.solveRecursive(5);
        assertThat(solutions.size()).isEqualTo(10);
    }

    @Test
    @DisplayName("should not give any solution for 3 queens")
    void solve3QueensRecursiveTest() {
        var solutions = Queens.solveRecursive(3);
        assertThat(solutions).isEmpty();
    }

    @Test
    @DisplayName("should solve queens problem for 4 queens")
    void solve4QueensIterativeTest() {
        var solutions = Queens.solveRecursive(4);
        assertThat(solutions.size()).isEqualTo(2);
        assertThat(solutions.get(0)).containsExactly(1, 3, 0, 2);
        assertThat(solutions.get(1)).containsExactly(2, 0, 3, 1);
    }

    @Test
    @DisplayName("should solve queens problem for 5 queens")
    void solve5QueensIterativeTest() {
        var solutions = Queens.solveIterative(5);
        assertThat(solutions.size()).isEqualTo(10);
    }

    @Test
    @DisplayName("should not give any solution for 3 queens")
    void solve3QueensIterativeTest() {
        var solutions = Queens.solveIterative(3);
        assertThat(solutions).isEmpty();
    }
}
