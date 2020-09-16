package dev.esz.algorithms.graphs;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TaskSchedulingTest {
    @Test
    @DisplayName("should return true in case the tasks can be scheduled")
    void isSchedulingPossible() {
        int[][] pre = {{0, 1}, {1, 2}};
        assertThat(TaskScheduling.isSchedulingPossible(3, pre)).isTrue();
    }

    @Test
    @DisplayName("should return false in case the tasks can not be scheduled")
    void isSchedulingPossible2() {
        int[][] pre = {{0, 1}, {1, 2}, {2, 0}};
        assertThat(TaskScheduling.isSchedulingPossible(3, pre)).isFalse();
    }

    @Test
    @DisplayName("should return true in case the tasks can be scheduled")
    void isSchedulingPossible3() {
        int[][] pre = {{2, 5}, {0, 5}, {0, 4}, {1, 4}, {3, 2}, {1, 3}};
        assertThat(TaskScheduling.isSchedulingPossible(6, pre)).isTrue();
    }
}
