package dev.esz.algorithms.math;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public interface Mathematical {
    static boolean isPrim(int number) {
        return IntStream.rangeClosed(2, (int) Math.floor(Math.sqrt(number)))
                .filter(i -> number % i == 0)
                .findAny()
                .isEmpty();
    }

    static List<Integer> firstNPrimes(int n) {
        return IntStream.iterate(2, i -> i + 1)
                .filter(Mathematical::isPrim)
                .limit(n)
                .boxed()
                .collect(Collectors.toList());

    }

    static int nthPrime(int n) {
        return IntStream.iterate(2, i -> i + 1)
                .filter(Mathematical::isPrim)
                .limit(n)
                .reduce((first, last) -> last)
                .orElseThrow();

    }
}
