package dev.esz.algorithms.backtracking;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CoinChangeTest {
    @Test
    @DisplayName("should return the number of ways the change can be made")
    void solveNumberOfWaysToMakeChange() {
        int[] coins = {1, 5};
        assertThat(CoinChange.numberOfWaysToMakeChange(6, coins)).isEqualTo(2);
    }

    @Test
    @DisplayName("should return the number of ways the change can be made")
    void solveNumberOfWaysToMakeChange2() {
        int[] coins = {5};
        assertThat(CoinChange.numberOfWaysToMakeChange(9, coins)).isEqualTo(0);
    }

    @Test
    @DisplayName("should return the number of ways the change can be made")
    void solveNumberOfWaysToMakeChange3() {
        int[] coins = {1, 5, 10, 25};
        assertThat(CoinChange.numberOfWaysToMakeChange(5, coins)).isEqualTo(2);
    }

    @Test
    @DisplayName("should return the number of ways the change can be made")
    void solveNumberOfWaysToMakeChange4() {
        int[] coins = {2, 3, 4, 7};
        assertThat(CoinChange.numberOfWaysToMakeChange(7, coins)).isEqualTo(3);
    }
}
