package dev.esz.algorithms.dp;

import java.util.Comparator;
import java.util.List;

// Given the weights and profits of ‘N’ items, we are asked to put these items in a knapsack which has a capacity ‘C’.
// The goal is to get the maximum profit from the items in the knapsack. Each item can only be selected once,
// as we don’t have multiple quantities of any item.

// Original problem: https://www.educative.io/courses/grokking-dynamic-programming-patterns-for-coding-interviews/RM1BDv71V60
public interface Knapsack {
    class Product {
        private final int profit;
        private final int weight;

        public Product(int profit, int weight) {
            this.profit = profit;
            this.weight = weight;
        }

        public int getProfit() {
            return profit;
        }

        public int getWeight() {
            return weight;
        }
    }

    static int solve(List<Product> products, int capacity) {
        products.sort(Comparator.comparingInt(Product::getWeight));

        int[][] dp = new int[2][capacity + 1];
        Product product = products.get(0);
        for (int c = 0; c < capacity - 1; c++) {
            if (product.getWeight() <= c)
                dp[0][c] = dp[1][c] = product.getProfit();
        }

        for (int i = 1; i < products.size(); i++) {
            product = products.get(i);
            for (int c = 0; c < capacity + 1; c++) {
                int profit1 = dp[(i - 1) % 2][c];
                int profit2 = product.getWeight() <= c ? product.getProfit() + dp[(i - 1) % 2][c - product.getWeight()] : 0;
                dp[i % 2][c] = Math.max(profit1, profit2);
            }
        }
        return dp[(products.size() - 1) % 2][capacity];
    }
}
