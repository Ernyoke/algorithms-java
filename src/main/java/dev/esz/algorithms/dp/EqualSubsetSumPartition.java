package dev.esz.algorithms.dp;

import java.util.Arrays;

// Given a set of positive numbers, find if we can partition it into two subsets such that the sum of elements
// in both the subsets is equal.

// Original problem: https://www.educative.io/courses/grokking-dynamic-programming-patterns-for-coding-interviews/3jEPRo5PDvx
public interface EqualSubsetSumPartition {
    static boolean canPartition(int[] num) {
        if (num == null || num.length < 2) {
            return false;
        }

        int sum = Arrays.stream(num).sum();
        if (sum % 2 == 1) {
            return false;
        }

        Arrays.sort(num);
        boolean[][] dp = new boolean[num.length][sum / 2 + 1];
        dp[0][num[0]] = true;

        for (int i = 0; i < num.length; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i < num.length; i++) {
            for (int j = 1; j < sum / 2 + 1; j++) {
                if (j - num[i] >= 0) {
                    dp[i][j] = dp[i - 1][j] | dp[i - 1][j - num[i]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[num.length - 1][sum / 2];
    }
}
