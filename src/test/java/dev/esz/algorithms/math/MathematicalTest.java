package dev.esz.algorithms.math;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MathematicalTest {

    @Test
    @DisplayName("should return true for 29")
    void isPrim29Test() {
        assertThat(Mathematical.isPrim(29)).isTrue();
    }

    @Test
    @DisplayName("should return false for 100")
    void isPrim100Test() {
        assertThat(Mathematical.isPrim(100)).isFalse();
    }

    @Test
    @DisplayName("should return the first n primes")
    void firstNPrimesTest() {
        assertThat(Mathematical.firstNPrimes(10)).containsExactly(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
    }

    @Test
    @DisplayName("should return the nth prime")
    void nthPrimeTest() {
        assertThat(Mathematical.nthPrime(10)).isEqualTo(29);
    }

    @Test
    @DisplayName("should return all primes less than 30")
    void primesLessThan30Test() {
        assertThat(Mathematical.primesLessThan(30)).containsExactly(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
    }
}
