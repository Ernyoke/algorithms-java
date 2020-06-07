package dev.esz.algorithms.dp;

import java.util.Map;

public interface RodCutting {
    // Given a rod of length n and a map which associates prices to lengths, determine the maximum value obtainable
    // by cutting up the rod and selling the pieces.
    static int solve(Map<Integer, Integer> lengthByPrice, int rodLength) {
        int[] dp = new int[rodLength + 1];

        for (int i = 0; i < rodLength + 1; i++) {
            if (lengthByPrice.containsKey(i)) {
                dp[i] = Math.max(dp[i], lengthByPrice.get(i));
            }
            for (Map.Entry<Integer, Integer> entry : lengthByPrice.entrySet()) {
                int length = entry.getKey();
                int price = entry.getValue();
                if (i - length >= 0) {
                    dp[i] = Math.max(dp[i], dp[i - length] + price);
                }
            }
        }

        return dp[rodLength];
    }
}
