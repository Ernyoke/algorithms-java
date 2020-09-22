package dev.esz.algorithms.math;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.assertj.core.api.Assertions.assertThat;

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
    @DisplayName("should return the first n probable primes")
    void firstNProbablePrimesTest() {
        assertThat(Mathematical.firstNProbablePrimes(20)).containsExactly(BigInteger.TWO, BigInteger.valueOf(3),
                BigInteger.valueOf(5), BigInteger.valueOf(7), BigInteger.valueOf(11), BigInteger.valueOf(13),
                BigInteger.valueOf(17), BigInteger.valueOf(19), BigInteger.valueOf(23), BigInteger.valueOf(29),
                BigInteger.valueOf(31), BigInteger.valueOf(37), BigInteger.valueOf(41), BigInteger.valueOf(43),
                BigInteger.valueOf(47), BigInteger.valueOf(53), BigInteger.valueOf(59), BigInteger.valueOf(61),
                BigInteger.valueOf(67), BigInteger.valueOf(71));
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
