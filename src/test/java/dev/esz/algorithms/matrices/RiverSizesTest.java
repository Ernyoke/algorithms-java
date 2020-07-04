package dev.esz.algorithms.matrices;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RiverSizesTest {

    @Test
    @DisplayName("should return an array with the length of all rivers")
    void riverSizesTest1() {
        int[][] matrix = {
                {1, 0, 0, 1, 0},
                {1, 0, 1, 0, 0},
                {0, 0, 1, 0, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 0}
        };
        List<Integer> result = RiverSizes.riverSizes(matrix);
        assertThat(result).containsExactlyInAnyOrder(1, 2, 2, 2, 5);
    }

    @Test
    @DisplayName("should return an array with the length of all rivers")
    void riverSizesTest2() {
        int[][] matrix = {
                {1, 0, 0, 1, 0, 1, 0, 0, 1, 1, 1, 0},
                {1, 0, 1, 0, 0, 1, 1, 1, 1, 0, 1, 0},
                {0, 0, 1, 0, 1, 1, 0, 1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1, 1, 0, 0, 0, 1, 0, 0},
                {1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 0, 1}
        };
        List<Integer> result = RiverSizes.riverSizes(matrix);
        System.out.println(result);
        assertThat(result).containsExactlyInAnyOrder(2, 1, 21, 5, 2, 1);
    }
}
