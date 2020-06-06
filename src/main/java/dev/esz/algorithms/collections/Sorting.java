package dev.esz.algorithms.collections;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public interface Sorting {
    static <E extends Comparable<? super E>> void quickSort(final List<E> list) {
        quickSort(list, Comparator.naturalOrder());
    }

    static <E> void quickSort(final List<E> list, final Comparator<? super E> comparator) {
        if (list.size() > 0) {
            final var pivot = list.get(list.size() / 2);
            final int lowerPartitionPosition = Misc.partition(list, item -> comparator.compare(item, pivot) < 0);
            final int upperPartitionPosition = lowerPartitionPosition + Misc.partition(
                    list.subList(lowerPartitionPosition, list.size()),
                    item -> comparator.compare(item, pivot) <= 0);
            quickSort(list.subList(0, lowerPartitionPosition), comparator);
            if (upperPartitionPosition < list.size()) {
                quickSort(list.subList(upperPartitionPosition, list.size()), comparator);
            }
        }
    }

    static <E extends Comparable<? super E>> void insertionSort(final List<E> list) {
        insertionSort(list, Comparator.naturalOrder());
    }

    static <E> void insertionSort(final List<E> list, final Comparator<? super E> comparator) {
        Function<Integer, Integer> computePosition = index -> {
            int position = Collections.binarySearch(list.subList(0, index), list.get(index), comparator);
            if (position < 0) {
                return Math.abs(position + 1);
            }
            return position;
        };

        for (int i = 1; i < list.size(); i++) {
            Collections.rotate(list.subList(computePosition.apply(i), i + 1), 1);
        }
    }

    static <E extends Comparable<? super E>> List<E> countingSort(final List<E> list) {
        return countingSort(list, Comparator.naturalOrder());
    }

    static <E> List<E> countingSort(final List<E> list, final Comparator<? super E> comparator) {
        int[] positions = new int[list.size()];

        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (comparator.compare(list.get(i), list.get(j)) < 0) {
                    positions[j]++;
                    continue;
                }
                positions[i]++;
            }
        }

        List<E> sorted = new ArrayList<>(Collections.nCopies(list.size(), (E) null));
        for (int i = 0; i < list.size(); i++) {
            sorted.set(positions[i], list.get(i));
        }

        return sorted;
    }

    static <E extends Comparable<? super E>> List<E> heapSort(final List<E> list) {
        return heapSort(list, Comparator.naturalOrder());
    }

    static <E> List<E> heapSort(final List<E> list, final Comparator<? super E> comparator) {
        Queue<E> heap = list.stream().collect(Collectors.toCollection(() -> new PriorityQueue<>(comparator)));
        return new ArrayList<>(heap);
    }

    private static <E> List<E> merge(final List<E> leftList, final List<E> rightList, final Comparator<? super E> comparator) {
        List<E> list = new ArrayList<>();
        int i = 0, j = 0;
        while (i < leftList.size() && j < rightList.size()) {
            if (comparator.compare(leftList.get(i), rightList.get(j)) < 0) {
                list.add(leftList.get(i++));
                continue;
            }
            list.add(rightList.get(j++));
        }

        for (; i < leftList.size(); i++) {
            list.add(leftList.get(i));
        }

        for (; j < rightList.size(); j++) {
            list.add(rightList.get(j));
        }

        return list;
    }

    static <E extends Comparable<? super E>> List<E> mergeSort(final List<E> list) {
        return mergeSort(list, Comparator.naturalOrder());
    }

    static <E> List<E> mergeSort(final List<E> list, final Comparator<? super E> comparator) {
        if (list.size() <= 1) {
            return list;
        }

        int middleIndex = list.size() / 2;

        List<E> leftSortedList = mergeSort(list.subList(0, middleIndex), comparator);
        List<E> rightSortedList = mergeSort(list.subList(middleIndex, list.size()), comparator);

        return merge(leftSortedList, rightSortedList, comparator);
    }
}
