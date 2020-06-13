package dev.esz.algorithms.matrices;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SquareOfZerosTest {

    @Test
    @DisplayName("should return true in case a square exists")
    void doesHaveSquareWithZeroBoundsTest() {
        List<List<Integer>> matrix = List.of(
                List.of(1, 1, 1, 0, 1, 0),
                List.of(0, 0, 0, 0, 0, 1),
                List.of(0, 1, 1, 1, 0, 1),
                List.of(0, 0, 0, 1, 0, 1),
                List.of(0, 1, 1, 1, 0, 1),
                List.of(0, 0, 0, 0, 0, 1)
        );
        assertThat(SquareOfZeros.doesHaveSquareWithZeroBounds(matrix)).isTrue();
    }

    @Test
    @DisplayName("should return true in case a square exists")
    void doesHaveSquareWithZeroBounds2Test() {
        List<List<Integer>> matrix = List.of(
                List.of(0, 0, 0, 1),
                List.of(0, 1, 0, 0),
                List.of(0, 1, 0, 0),
                List.of(0, 1, 0, 1)
        );
        assertThat(SquareOfZeros.doesHaveSquareWithZeroBounds(matrix)).isTrue();
    }

    @Test
    @DisplayName("should return false in case no square exists")
    void doesHaveSquareWithZeroBounds3Test() {
        List<List<Integer>> matrix = List.of(
                List.of(0, 0, 0),
                List.of(0, 1, 0),
                List.of(0, 1, 0)
        );
        assertThat(SquareOfZeros.doesHaveSquareWithZeroBounds(matrix)).isFalse();
    }

    @Test
    @DisplayName("should return false in case no square exists")
    void doesHaveSquareWithZeroBounds4Test() {
        List<List<Integer>> matrix = List.of(
                List.of(0, 0, 0, 1),
                List.of(0, 1, 1, 0),
                List.of(0, 1, 0, 0),
                List.of(0, 1, 0, 1)
        );
        assertThat(SquareOfZeros.doesHaveSquareWithZeroBounds(matrix)).isFalse();
    }
}
