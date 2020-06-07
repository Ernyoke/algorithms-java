package dev.esz.algorithms.collections;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

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
}
