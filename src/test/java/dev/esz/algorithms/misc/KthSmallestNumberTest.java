package dev.esz.algorithms.misc;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class KthSmallestNumberTest {

    @Test
    @DisplayName("should return the 3rd smallest number")
    void findKthSmallestNumberTest1() {
        assertThat(KthSmallestNumber.findKthSmallestNumber(new int[]{1, 5, 12, 2, 11, 5}, 3)).isEqualTo(5);
    }

    @Test
    @DisplayName("should return the 4th smallest number")
    void findKthSmallestNumberTest2() {
        assertThat(KthSmallestNumber.findKthSmallestNumber(new int[]{1, 5, 12, 2, 11, 5}, 4)).isEqualTo(5);
    }

    @Test
    @DisplayName("should return the 3rd smallest number")
    void findKthSmallestNumberTest3() {
        assertThat(KthSmallestNumber.findKthSmallestNumber(new int[]{5, 12, 11, -1, 12}, 3)).isEqualTo(11);
    }
}
