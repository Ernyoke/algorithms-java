package dev.esz.algorithms.backtracking;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PermutationsTest {

    @Test
    @DisplayName("should return all of the permutations")
    void getPermutationsTest() {
        var solutions = Permutations.getPermutations(List.of(1, 2, 3));
        assertThat(solutions).contains(List.of(1, 2, 3));
        assertThat(solutions).contains(List.of(1, 3, 2));
        assertThat(solutions).contains(List.of(2, 1, 3));
        assertThat(solutions).contains(List.of(2, 3, 1));
        assertThat(solutions).contains(List.of(3, 2, 1));
        assertThat(solutions).contains(List.of(3, 1, 2));
        assertThat(solutions.size()).isEqualTo(6);
    }
}
