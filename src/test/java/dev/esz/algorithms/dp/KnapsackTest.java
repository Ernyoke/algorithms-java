package dev.esz.algorithms.dp;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class KnapsackTest {

    @Test
    @DisplayName("should put the items in the knapsack in a way that maximum profit is reached")
    void solveTest() {
        List<Knapsack.Product> products = new ArrayList<>(List.of(
                new Knapsack.Product(1, 1),
                new Knapsack.Product(10, 3),
                new Knapsack.Product(6, 2),
                new Knapsack.Product(16, 5)
        ));
        assertThat(Knapsack.solve(products, 5)).isEqualTo(16);
    }
}
