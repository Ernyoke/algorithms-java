package dev.esz.algorithms.dp;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class EqualSubsetSumPartitionTest {

    @Test
    @DisplayName("should return true in case the array can be partitioned")
    void canPartitionTest() {
        assertThat(EqualSubsetSumPartition.canPartition(new int[] {1, 2, 3, 4})).isTrue();
    }
}
