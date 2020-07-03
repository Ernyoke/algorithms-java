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

    @Test
    @DisplayName("should compute the list of running sums")
    void runningSumTest() {
        List<Integer> list = List.of(1, 3, 5, 10);
        assertThat(Misc.runningSum(list, Integer::sum)).containsExactly(1, 4, 9, 19);
    }

    @Test
    @DisplayName("should compute the list of string concatenations as result for running sums")
    void runningSumConcatTest() {
        List<String> list = List.of("a", "b", "c", "d");
        assertThat(Misc.runningSum(list, String::concat)).containsExactly("a", "ab", "abc", "abcd");
    }


    @Test
    @DisplayName("should compute the sum of the elements from the list using recursive reduction")
    void reduceTest() {
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6);
        assertThat(Misc.reduce(list, Integer::sum, 0)).isEqualTo(21);
    }

    @Test
    @DisplayName("should compute the sum of the elements from an list of 1 element using recursive reduction")
    void reduceOneElementTest() {
        List<Integer> list = List.of(1);
        assertThat(Misc.reduce(list, Integer::sum, 0)).isEqualTo(1);
    }

    @Test
    @DisplayName("should compute the sum of the elements from an list array using recursive reduction")
    void reduceEmptyListTest() {
        List<Integer> list = List.of();
        assertThat(Misc.reduce(list, Integer::sum, 0)).isEqualTo(0);
    }

    @Test
    @DisplayName("should compute the sum of the elements from an list of 2 element using recursive reduction")
    void reduceTwoElementsTest() {
        List<Integer> list = List.of(1, 2);
        assertThat(Misc.reduce(list, Integer::sum, 0)).isEqualTo(3);
    }

    @Test
    @DisplayName("should return the first positive element not present in input array")
    void smallestPositiveTest() {
        int[] a = {1, 3, 6, 4, 1, 2};
        assertThat(Misc.firstPositive(a)).isEqualTo(5);
    }

    @Test
    @DisplayName("should return the first positive element not present in input array")
    void smallestPositiveTest2() {
        int[] a = {1, 2, 3};
        assertThat(Misc.firstPositive(a)).isEqualTo(4);
    }

    @Test
    @DisplayName("should return the first positive element not present in input array in case of only negative elements")
    void smallestPositiveOnlyNegativeTest() {
        int[] a = {-1, -3};
        assertThat(Misc.firstPositive(a)).isEqualTo(1);
    }
}
