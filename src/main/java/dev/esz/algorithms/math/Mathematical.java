package dev.esz.algorithms.math;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public interface Mathematical {
    // Decide if an integer number is prime or not.
    static boolean isPrim(int number) {
        return IntStream.rangeClosed(2, (int) Math.floor(Math.sqrt(number)))
                .filter(i -> number % i == 0)
                .findAny()
                .isEmpty();
    }

    // Return a list with the first N prime numbers.
    static List<Integer> firstNPrimes(int n) {
        return IntStream.iterate(2, i -> i + 1)
                .filter(Mathematical::isPrim)
                .limit(n)
                .boxed()
                .collect(Collectors.toList());
    }

    // Return the nth prime (n should start from 0).
    static int nthPrime(int n) {
        return IntStream.iterate(2, i -> i + 1)
                .filter(Mathematical::isPrim)
                .limit(n)
                .reduce((first, last) -> last)
                .orElseThrow();
    }

    // Return all primes less then n using sieve of Eratosthenes
    static List<Integer> primesLessThan(int n) {
        List<Integer> primes = new ArrayList<>();
        if (n <= 0) {
            return primes;
        }

        Predicate<Integer> sieve = number -> number % 2 != 0;
        primes.add(2);

        for (int i = 3; i < n; i++) {
            final int potentialPrime = i;
            if (sieve.test(potentialPrime)) {
                primes.add(potentialPrime);
                sieve = sieve.and(number -> number % potentialPrime != 0);
            }
        }

        return primes;
    }
}
