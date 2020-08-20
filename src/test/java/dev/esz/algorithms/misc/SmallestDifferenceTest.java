package dev.esz.algorithms.misc;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SmallestDifferenceTest {

    @Test
    @DisplayName("should return the pair closest to zero")
    void smallestDifference() {
        int[] arrayOne = {-1, 5, 10, 20, 28, 3};
        int[] arrayTwo = {26, 134, 135, 15, 17};
        assertThat(SmallestDifference.smallestDifference(arrayOne, arrayTwo)).isEqualTo(new int[]{28, 26});
    }

    @Test
    @DisplayName("should return the pair closest to zero")
    void smallestDifference2() {
        int[] arrayOne = {-1, 5, 10, 20, 3};
        int[] arrayTwo = {26, 134, 135, 15, 17};
        assertThat(SmallestDifference.smallestDifference(arrayOne, arrayTwo)).isEqualTo(new int[]{20, 17});
    }

    @Test
    @DisplayName("should return the pair closest to zero")
    void smallestDifference3() {
        int[] arrayOne = {10, 0, 20, 25, 2000};
        int[] arrayTwo = {1005, 1006, 1014, 1032, 1031};
        assertThat(SmallestDifference.smallestDifference(arrayOne, arrayTwo)).isEqualTo(new int[]{2000, 1032});
    }
}
