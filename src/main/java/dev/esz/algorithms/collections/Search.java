package dev.esz.algorithms.collections;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public interface Search {
    static <E extends Comparable<? super E>> Optional<E> quickSelect(final List<E> list, int k) {
        return quickSelect(list, k, Comparator.naturalOrder());
    }

    static <E> Optional<E> quickSelect(final List<E> list, int k, final Comparator<? super E> comparator) {
        if (list.size() > 0) {
            final var pivot = list.get(list.size() / 2);
            final int lowerPartitionPosition = Misc.partition(list, item -> comparator.compare(item, pivot) < 0);
            final int upperPartitionPosition = lowerPartitionPosition +
                    Misc.partition(list.subList(lowerPartitionPosition, list.size()), item -> comparator.compare(item, pivot) <= 0);
            if (k == lowerPartitionPosition || k == upperPartitionPosition - 1) {
                return Optional.of(list.get(k));
            } else {
                if (k < lowerPartitionPosition) {
                    return quickSelect(list.subList(0, lowerPartitionPosition), k, comparator);
                }
                return quickSelect(list.subList(upperPartitionPosition, list.size()), k - upperPartitionPosition, comparator);
            }
        }
        return Optional.empty();
    }

    // Return the position of the first element which satisfies the predicate.
    static <E> Optional<Integer> linearSearch(final List<E> list, final Predicate<E> predicate) {
        for (int i = 0; i < list.size(); i++) {
            if (predicate.test(list.get(i))) {
                return Optional.of(i);
            }
        }
        return Optional.empty();
    }

    // Return the position of the first occurrence of the item.
    static <E extends Comparable<? super E>> Optional<Integer> linearSearch(final E item, final List<E> list) {
        return linearSearch(list, item::equals);
    }
}
