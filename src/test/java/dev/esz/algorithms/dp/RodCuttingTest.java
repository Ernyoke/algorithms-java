package dev.esz.algorithms.dp;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class RodCuttingTest {

    @Test
    @DisplayName("should return the correct maximum amount in case the rod can be cut without waste")
    void rodCuttingTest() {
        Map<Integer, Integer> lengthByPrice = Map.of(
                1, 1,
                2, 5,
                3, 8,
                4, 9,
                5, 10,
                6, 17,
                8, 20
        );
        assertThat(RodCutting.solve(lengthByPrice, 8)).isEqualTo(22);
    }

    @Test
    @DisplayName("should return the correct maximum amount in case the rod can not be cut with waste")
    void rodCuttingNotExactTest() {
        Map<Integer, Integer> lengthByPrice = Map.of(
                2, 5,
                4, 9,
                5, 10,
                6, 17,
                8, 20
        );
        assertThat(RodCutting.solve(lengthByPrice, 3)).isEqualTo(5);
    }
}
