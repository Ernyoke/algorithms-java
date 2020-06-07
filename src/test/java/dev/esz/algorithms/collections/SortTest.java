package dev.esz.algorithms.collections;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SortTest {

    @Test
    @DisplayName("should sort the list using quick sort")
    void quickSortTest() {
        List<Integer> list = new ArrayList<>(List.of(3, 1, 2, 4, 7, 6));
        Sort.quickSort(list);
        assertThat(list).containsExactly(1, 2, 3, 4, 6, 7);
    }

    @Test
    @DisplayName("should sort a larger list using quick sort")
    void quickSortTestLarge() {
        List<Integer> list = new ArrayList<>(List.of(3, 1, 2, 4, 7, 6, 10, 0, 12, 15, 14, -1, -2, 3, 4));
        Sort.quickSort(list);
        assertThat(list).containsExactly(-2, -1, 0, 1, 2, 3, 3, 4, 4, 6, 7, 10, 12, 14, 15);
    }

    @Test
    @DisplayName("should sort a list with two elements using quick sort")
    void quickSortTest2Elements() {
        List<Integer> list = new ArrayList<>(List.of(2, 1));
        Sort.quickSort(list);
        assertThat(list).containsExactly(1, 2);
    }

    @Test
    @DisplayName("should sort a list with tree elements using quick sort")
    void quickSortTest3Elements() {
        List<Integer> list = new ArrayList<>(List.of(3, 1, 2));
        Sort.quickSort(list);
        assertThat(list).containsExactly(1, 2, 3);
    }

    @Test
    @DisplayName("should sort a reverted list with tree elements using quick sort")
    void quickSortTest3ElementsReverse() {
        List<Integer> list = new ArrayList<>(List.of(3, 2, 1));
        Sort.quickSort(list);
        assertThat(list).containsExactly(1, 2, 3);
    }

    @Test
    @DisplayName("should sort a reverted list with one elements using quick sort")
    void quickSortTest1Element() {
        List<Integer> list = new ArrayList<>(List.of(3));
        Sort.quickSort(list);
        assertThat(list).containsExactly(3);
    }

    @Test
    @DisplayName("should not throw errors with an empty list using quick sort")
    void quickSortTestEmptyList() {
        List<Integer> list = new ArrayList<>();
        Sort.quickSort(list);
        assertThat(list).isEmpty();
    }

    @Test
    @DisplayName("should sort the list with custom comparator using quick sort")
    void quickSortTestCustomComparator() {
        List<Integer> list = new ArrayList<>(List.of(3, 1, 2, 4, 7, 6));
        Sort.quickSort(list, Comparator.reverseOrder());
        assertThat(list).containsExactly(7, 6, 4, 3, 2, 1);
    }

    @Test
    @DisplayName("should sort the list using insertion sort")
    void insertionSortTest() {
        List<Integer> list = new ArrayList<>(List.of(3, 1, 2, 4, 7, 6));
        Sort.insertionSort(list);
        assertThat(list).containsExactly(1, 2, 3, 4, 6, 7);
    }

    @Test
    @DisplayName("should sort a larger list  using insertion sort")
    void insertionSortTestLarge() {
        List<Integer> list = new ArrayList<>(List.of(3, 1, 2, 4, 7, 6, 10, 0, 12, 15, 14, -1, -2, 3, 4));
        Sort.insertionSort(list);
        assertThat(list).containsExactly(-2, -1, 0, 1, 2, 3, 3, 4, 4, 6, 7, 10, 12, 14, 15);
    }

    @Test
    @DisplayName("should sort a list with two elements using insertion sort")
    void insertionSortTest2Elements() {
        List<Integer> list = new ArrayList<>(List.of(2, 1));
        Sort.insertionSort(list);
        assertThat(list).containsExactly(1, 2);
    }

    @Test
    @DisplayName("should sort a list with tree elements using insertion sort")
    void insertionSortTest3Elements() {
        List<Integer> list = new ArrayList<>(List.of(3, 1, 2));
        Sort.insertionSort(list);
        assertThat(list).containsExactly(1, 2, 3);
    }

    @Test
    @DisplayName("should sort a reverted list with tree elements using insertion sort")
    void insertionSortTest3ElementsReverse() {
        List<Integer> list = new ArrayList<>(List.of(3, 2, 1));
        Sort.insertionSort(list);
        assertThat(list).containsExactly(1, 2, 3);
    }

    @Test
    @DisplayName("should sort a reverted list with one elements using insertion sort")
    void insertionSortTest1Element() {
        List<Integer> list = new ArrayList<>(List.of(3));
        Sort.insertionSort(list);
        assertThat(list).containsExactly(3);
    }

    @Test
    @DisplayName("should not throw errors with an empty list using insertion sort")
    void insertionSortTestEmptyList() {
        List<Integer> list = new ArrayList<>();
        Sort.insertionSort(list);
        assertThat(list).isEmpty();
    }

    @Test
    @DisplayName("should sort the list with custom comparator using insertion sort")
    void insertionSortTestCustomComparator() {
        List<Integer> list = new ArrayList<>(List.of(3, 1, 2, 4, 7, 6));
        Sort.insertionSort(list, Comparator.reverseOrder());
        assertThat(list).containsExactly(7, 6, 4, 3, 2, 1);
    }

    @Test
    @DisplayName("should sort a larger list using counting sort")
    void countingSortTestLarge() {
        List<Integer> list = new ArrayList<>(List.of(3, 1, 2, 4, 7, 6, 10, 0, 12, 15, 14, -1, -2, 3, 4));
        List<Integer> sorted = Sort.countingSort(list);
        assertThat(sorted).containsExactly(-2, -1, 0, 1, 2, 3, 3, 4, 4, 6, 7, 10, 12, 14, 15);
    }

    @Test
    @DisplayName("should sort the list using counting sort")
    void countingSortTest() {
        List<Integer> list = new ArrayList<>(List.of(3, 1, 2, 4, 7, 6));
        List<Integer> sorted = Sort.countingSort(list);
        assertThat(sorted).containsExactly(1, 2, 3, 4, 6, 7);
    }

    @Test
    @DisplayName("should sort a list with two elements using counting sort")
    void countingSortTest2Elements() {
        List<Integer> list = new ArrayList<>(List.of(2, 1));
        List<Integer> sorted = Sort.countingSort(list);
        assertThat(sorted).containsExactly(1, 2);
    }

    @Test
    @DisplayName("should sort a list with tree elements using counting sort")
    void countingSortTest3Elements() {
        List<Integer> list = new ArrayList<>(List.of(3, 1, 2));
        List<Integer> sorted = Sort.countingSort(list);
        assertThat(sorted).containsExactly(1, 2, 3);
    }

    @Test
    @DisplayName("should sort a reverted list with tree elements using counting sort")
    void countingSortTest3ElementsReverse() {
        List<Integer> list = new ArrayList<>(List.of(3, 2, 1));
        List<Integer> sorted = Sort.countingSort(list);
        assertThat(sorted).containsExactly(1, 2, 3);
    }

    @Test
    @DisplayName("should sort a reverted list with one elements using counting sort")
    void countingSortTest1Element() {
        List<Integer> list = new ArrayList<>(List.of(3));
        List<Integer> sorted = Sort.countingSort(list);
        assertThat(sorted).containsExactly(3);
    }

    @Test
    @DisplayName("should not throw errors with an empty list using counting sort")
    void countingSortTestEmptyList() {
        List<Integer> list = new ArrayList<>();
        List<Integer> sorted = Sort.countingSort(list);
        assertThat(sorted).isEmpty();
    }

    @Test
    @DisplayName("should sort the list with custom comparator using counting sort")
    void countingSortTestCustomComparator() {
        List<Integer> list = new ArrayList<>(List.of(3, 1, 2, 4, 7, 6));
        List<Integer> sorted = Sort.countingSort(list, Comparator.reverseOrder());
        assertThat(sorted).containsExactly(7, 6, 4, 3, 2, 1);
    }

    @Test
    @DisplayName("should sort a larger list using heap sort")
    void heapSortTestLarge() {
        List<Integer> list = new ArrayList<>(List.of(3, 1, 2, 4, 7, 6, 10, 0, 12, 15, 14, -1, -2, 3, 4));
        List<Integer> sorted = Sort.heapSort(list);
        assertThat(sorted).containsExactly(-2, -1, 0, 1, 2, 3, 3, 4, 4, 6, 7, 10, 12, 14, 15);
    }

    @Test
    @DisplayName("should sort the list using heap sort")
    void heapSortTest() {
        List<Integer> list = new ArrayList<>(List.of(3, 1, 2, 4, 7, 6));
        List<Integer> sorted = Sort.heapSort(list);
        assertThat(sorted).containsExactly(1, 2, 3, 4, 6, 7);
    }

    @Test
    @DisplayName("should sort a list with two elements using heap sort")
    void heapSortTest2Elements() {
        List<Integer> list = new ArrayList<>(List.of(2, 1));
        List<Integer> sorted = Sort.heapSort(list);
        assertThat(sorted).containsExactly(1, 2);
    }

    @Test
    @DisplayName("should sort a list with tree elements using heap sort")
    void heapSortTest3Elements() {
        List<Integer> list = new ArrayList<>(List.of(3, 1, 2));
        List<Integer> sorted = Sort.heapSort(list);
        assertThat(sorted).containsExactly(1, 2, 3);
    }

    @Test
    @DisplayName("should sort a reverted list with tree elements using heap sort")
    void heapSortTest3ElementsReverse() {
        List<Integer> list = new ArrayList<>(List.of(3, 2, 1));
        List<Integer> sorted = Sort.heapSort(list);
        assertThat(sorted).containsExactly(1, 2, 3);
    }

    @Test
    @DisplayName("should sort a reverted list with one elements using heap sort")
    void heapSortTest1Element() {
        List<Integer> list = new ArrayList<>(List.of(3));
        List<Integer> sorted = Sort.heapSort(list);
        assertThat(sorted).containsExactly(3);
    }

    @Test
    @DisplayName("should not throw errors with an empty list using heap sort")
    void heapSortTestEmptyList() {
        List<Integer> list = new ArrayList<>();
        List<Integer> sorted = Sort.heapSort(list);
        assertThat(sorted).isEmpty();
    }

    @Test
    @DisplayName("should sort the list with custom comparator using heap sort")
    void heapSortTestCustomComparator() {
        List<Integer> list = new ArrayList<>(List.of(3, 1, 2, 4, 7, 6));
        List<Integer> sorted = Sort.heapSort(list, Comparator.reverseOrder());
        assertThat(sorted).containsExactly(7, 6, 4, 3, 2, 1);
    }

    @Test
    @DisplayName("should sort a larger list using merge sort")
    void mergeSortTestLarge() {
        List<Integer> list = new ArrayList<>(List.of(3, 1, 2, 4, 7, 6, 10, 0, 12, 15, 14, -1, -2, 3, 4));
        List<Integer> sorted = Sort.mergeSort(list);
        assertThat(sorted).containsExactly(-2, -1, 0, 1, 2, 3, 3, 4, 4, 6, 7, 10, 12, 14, 15);
    }

    @Test
    @DisplayName("should sort a list with two elements using merge sort")
    void mergeSortTest2Elements() {
        List<Integer> list = new ArrayList<>(List.of(2, 1));
        List<Integer> sorted = Sort.mergeSort(list);
        assertThat(sorted).containsExactly(1, 2);
    }

    @Test
    @DisplayName("should sort a list with tree elements using merge sort")
    void mergeSortTest3Elements() {
        List<Integer> list = new ArrayList<>(List.of(3, 1, 2));
        List<Integer> sorted = Sort.mergeSort(list);
        assertThat(sorted).containsExactly(1, 2, 3);
    }

    @Test
    @DisplayName("should sort a reverted list with tree elements using merge sort")
    void mergeSortTest3ElementsReverse() {
        List<Integer> list = new ArrayList<>(List.of(3, 2, 1));
        List<Integer> sorted = Sort.mergeSort(list);
        assertThat(sorted).containsExactly(1, 2, 3);
    }

    @Test
    @DisplayName("should sort a reverted list with one elements using merge sort")
    void mergeSortTest1Element() {
        List<Integer> list = new ArrayList<>(List.of(3));
        List<Integer> sorted = Sort.mergeSort(list);
        assertThat(sorted).containsExactly(3);
    }

    @Test
    @DisplayName("should not throw errors with an empty list using merge sort")
    void mergeSortTestEmptyList() {
        List<Integer> list = new ArrayList<>();
        List<Integer> sorted = Sort.mergeSort(list);
        assertThat(sorted).isEmpty();
    }

    @Test
    @DisplayName("should sort the list with custom comparator using merge sort")
    void mergeSortTestCustomComparator() {
        List<Integer> list = new ArrayList<>(List.of(3, 1, 2, 4, 7, 6));
        List<Integer> sorted = Sort.mergeSort(list, Comparator.reverseOrder());
        assertThat(sorted).containsExactly(7, 6, 4, 3, 2, 1);
    }
}
