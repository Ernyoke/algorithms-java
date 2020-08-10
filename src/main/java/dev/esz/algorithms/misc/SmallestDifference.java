package dev.esz.algorithms.misc;

import java.util.Arrays;

// Find the pair from the two arrays (one value from each) whose absolute difference is the closest to zeo.
// Original problem: https://www.algoexpert.io/questions/Smallest%20Difference
public interface SmallestDifference {
    private static void updateResult(int[] arrayOne, int[] arrayTwo, int[] result, int i, int j) {
        if (Math.abs(arrayOne[i] - arrayTwo[j]) < Math.abs(result[0] - result[1])) {
            result[0] = arrayOne[i];
            result[1] = arrayTwo[j];
        }
    }

    static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
        Arrays.sort(arrayOne);
        Arrays.sort(arrayTwo);
        int[] result = {arrayOne[0], arrayTwo[0]};
        int i = 0;
        int j = 0;
        while (i < arrayOne.length - 1 && j < arrayTwo.length - 1) {
            if (arrayOne[i + 1] < arrayTwo[j + 1]) {
                i++;
            } else {
                j++;
            }

            updateResult(arrayOne, arrayTwo, result, i, j);
        }

        while (i < arrayOne.length - 1) {
            i++;
            updateResult(arrayOne, arrayTwo, result, i, j);
        }

        while (j < arrayTwo.length - 1) {
            j++;
            updateResult(arrayOne, arrayTwo, result, i, j);
        }
        return result;
    }
}
