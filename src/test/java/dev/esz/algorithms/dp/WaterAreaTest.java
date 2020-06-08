package dev.esz.algorithms.dp;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class WaterAreaTest {

    @Test
    @DisplayName("should return the correct water surface area")
    void waterArea() {
        int[] heights = new int[]{0, 8, 0, 0, 5, 0, 0, 10, 0, 0, 1, 1, 0, 3};
        assertThat(WaterArea.computeArea(heights)).isEqualTo(48);
    }
}
