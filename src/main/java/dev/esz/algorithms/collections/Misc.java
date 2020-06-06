package dev.esz.algorithms.collections;

import java.util.*;
import java.util.function.Predicate;

public interface Misc {
    // Maximum subarray: find a contiguous subarray with the largest sum.
    static int kadane(final List<Integer> list) {
        int bestSum = 0;
        int currentSum = 0;
        for (Integer number : list) {
            bestSum = Math.max(bestSum, currentSum = Math.max(0, currentSum + number));
        }
        return bestSum;
    }

    // Return the position of the first element which satisfies the predicate.
    static <E> Optional<Integer> findPositionIf(final List<E> list, final Predicate<E> predicate) {
        for (int i = 0; i < list.size(); i++) {
            if (predicate.test(list.get(i))) {
                return Optional.of(i);
            }
        }
        return Optional.empty();
    }

    // Partition the list according to the following rule: all the elements which satisfy the predicate should be at
    // the top of the list (in the positions closer to 0), all the other at the bottom.
    // Return the position of the last element which satisfies the rules above.
    static <E> int partition(final List<E> list, final Predicate<E> predicate) {
        int position = findPositionIf(list, item -> !predicate.test(item)).orElse(list.size() + 1);

        for (int i = position + 1; i < list.size(); i++) {
            if (predicate.test(list.get(i))) {
                Collections.swap(list, position++, i);
            }
        }
        return position;
    }

    // Find the Kth most frequent element
    static <E> Optional<E> kMostFrequent(final List<E> list, final int k) {
        final Map<E, Integer> histogram = new HashMap<>();
        for (var item : list) {
            histogram.compute(item, (key, value) -> value == null ? 1 : value + 1);
        }

        final Queue<Map.Entry<E, Integer>> queue = new PriorityQueue<>((e1, e2) -> e2.getValue() - e1.getValue());
        histogram.entrySet().forEach(queue::offer);

        int i = 0;
        while (!queue.isEmpty()) {
            if (i == k) {
                return Optional.of(queue.poll().getKey());
            }
            i++;
            queue.poll();
        }
        return Optional.empty();
    }
}
