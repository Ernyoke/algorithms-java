package dev.esz.algorithms.misc;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SingleCycleCheckTest {

    @Test
    void hasSingleCycle() {
        int[] array = new int[]{2, 3, 1, -4, -4, 2};
        assertThat(SingleCycleCheck.hasSingleCycle(array)).isTrue();
    }

    @Test
    void hasSingleCycle2() {
        int[] array = new int[]{1, 1, 1, 1, 2};
        assertThat(SingleCycleCheck.hasSingleCycle(array)).isFalse();
    }

    @Test
    void hasSingleCycle3() {
        int[] array = new int[]{2, 2, -1};
        assertThat(SingleCycleCheck.hasSingleCycle(array)).isTrue();
    }

    @Test
    void hasSingleCycle4() {
        int[] array = new int[]{1, 2, 3, 4, -2, 3, 7, 8, -26};
        assertThat(SingleCycleCheck.hasSingleCycle(array)).isTrue();
    }
}
