package dev.esz.algorithms.dp;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MiscTest {

    @Test
    @DisplayName("should return the maximum sum of non-adjacent elements")
    void maxSums() {
        int[] array = new int[] {75, 105, 120, 75, 90, 135};
        assertThat(Misc.maxSubsetSumNoAdjacent(array)).isEqualTo(330);
    }

    @Test
    @DisplayName("should return the maximum sum of non-adjacent elements")
    void maxSums2() {
        int[] array = new int[] {4, 3, 5, 200, 5, 3};
        assertThat(Misc.maxSubsetSumNoAdjacent(array)).isEqualTo(207);
    }
}
