package dev.esz.algorithms.dp;

import java.util.Arrays;

public interface Misc {

    // Return the maximum sum of non-adjacent elements.
    // Original problem: https://www.algoexpert.io/questions/Max%20Subset%20Sum%20No%20Adjacent
    static int maxSubsetSumNoAdjacent(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int[] maxSums = Arrays.copyOf(array, array.length);
        for (int i = 1; i < maxSums.length; i++) {
            if (i - 2 >= 0) {
                maxSums[i] = Math.max(maxSums[i - 2] + maxSums[i], maxSums[i - 1]);
            } else {
                maxSums[i] = Math.max(maxSums[i], maxSums[i - 1]);
            }
        }
        return maxSums[array.length - 1];
    }
}
