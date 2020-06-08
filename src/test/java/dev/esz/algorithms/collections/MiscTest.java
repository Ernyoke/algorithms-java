package dev.esz.algorithms.collections;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static org.assertj.core.api.Assertions.assertThat;

class MiscTest {
    @Test
    @DisplayName("should return the correct value for maximum sub of a contiguous subarray")
    public void kadaneTest() {
        assertThat(Misc.kadane(List.of(1, -1, 2, 3, -2))).isEqualTo(5);
    }

    @Test
    @DisplayName("should return the correct value for maximum sub of a contiguous subarray")
    public void kadanePositiveListTest() {
        assertThat(Misc.kadane(List.of(1, 1, 2, 3, 2))).isEqualTo(9);
    }

    @Test
    @DisplayName("should return 0 in case all the items are negative in the list")
    public void kadaneNegativeListTest() {
        assertThat(Misc.kadane(List.of(-1, -1, -2, -3, -2))).isEqualTo(0);
    }

    @Test
    @DisplayName("should partition the list based on the predicate")
    public void partitionTest() {
        List<Integer> list = new ArrayList<>(List.of(2, 3, 2, 1, 5, 6));
        Predicate<Integer> predicate = item -> item % 2 == 1;

        int partitionPosition = Misc.partition(list, predicate);

        assertThat(partitionPosition).isEqualTo(3);
        for (int i = 0; i < partitionPosition; i++) {
            assertThat(predicate.test(list.get(i))).isTrue();
        }
        for (int i = partitionPosition; i < list.size(); i++) {
            assertThat(predicate.test(list.get(i))).isFalse();
        }
    }

    @Test
    @DisplayName("should return the kth most frequent element")
    void kthMostFrequentTest() {
        List<Integer> list = List.of(1, 1, 1, 1, 2, 2, 2, 3, 3, 3, 3, 3);
        assertThat(Misc.kMostFrequent(list, 2).orElseThrow()).isEqualTo(2);
    }

    @Test
    @DisplayName("should return empty if the kth most frequent element does not exist")
    void kMostFrequentNotExistTest() {
        List<Integer> list = List.of(1, 1, 1, 1, 2, 2, 2, 3, 3, 3, 3, 3);
        assertThat(Misc.kMostFrequent(list, 3)).isEmpty();
    }
}
