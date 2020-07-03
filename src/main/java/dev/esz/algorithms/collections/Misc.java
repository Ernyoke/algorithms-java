package dev.esz.algorithms.collections;

import java.util.*;
import java.util.function.BiFunction;
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

    // Partition the list according to the following rule: all the elements which satisfy the predicate should be at
    // the top of the list (in the positions closer to 0), all the other at the bottom.
    // Return the position of the last element which satisfies the rules above.
    static <E> int partition(final List<E> list, final Predicate<E> predicate) {
        int position = Search.linearSearch(list, predicate.negate()).orElse(list.size());

        for (int i = position + 1; i < list.size(); i++) {
            if (predicate.test(list.get(i))) {
                Collections.swap(list, position++, i);
            }
        }

        return position;
    }

    // Find the Kth most frequent element
    static <E> Optional<E> kMostFrequent(final Collection<E> collection, final int k) {
        final Map<E, Integer> histogram = new HashMap<>();
        for (var item : collection) {
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

    // Compute list of running sums for an input list.
    // Example: [1, 2, 3, 5] -> [1, 3, 6, 11]
    static <E> List<E> runningSum(final List<E> list, BiFunction<E, E, E> sum) {
        List<E> runningSumList = new ArrayList<>();
        if (list.size() <= 0) {
            return runningSumList;
        }

        runningSumList.add(list.get(0));

        for (int i = 1; i < list.size(); i++) {
            runningSumList.add(sum.apply(runningSumList.get(i - 1), list.get(i)));
        }

        return runningSumList;
    }

    // Recursive reduction
    // It is assumed that reduction function is commutative, otherwise the algorithm uses fold-left approach.
    static <E> E reduce(final List<E> list, BiFunction<E, E, E> reduction, E initialValue) {
        if (list.size() <= 0) {
            return initialValue;
        }

        if (list.size() == 1) {
            return reduction.apply(initialValue, list.get(0));
        }

        return reduction.apply(reduce(list.subList(0, list.size() / 2), reduction, initialValue),
                reduce(list.subList(list.size() / 2, list.size()), reduction, initialValue));
    }

    // Should return the first positive element bigger than 0 which is not present in the input array.
    static int firstPositive(int[] numbers) {
        Set<Integer> set = new HashSet<>();
        for (int a : numbers) {
            if (a > 0) {
                set.add(a);
            }
        }
        for (int i = 1; i < Integer.MAX_VALUE; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return 0;
    }
}
