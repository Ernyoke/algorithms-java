package dev.esz.algorithms.strings;

import java.util.Arrays;

public interface KnuthMorrisPratt {
    private static int[] computePattern(String string) {
        int[] pattern = new int[string.length()];
        Arrays.fill(pattern, -1);
        int i = 0, j = 1;
        while (j < string.length()) {
            if (string.charAt(i) == string.charAt(j)) {
                pattern[j++] = i++;
            } else {
                if (i > 0) {
                    i = pattern[i - 1] + 1;
                } else {
                    j++;
                }
            }
        }
        return pattern;
    }

    // Knuth-Morris-Pratt substring match algorithm.
    // https://www.algoexpert.io/questions/Knuth%E2%80%94Morris%E2%80%94Pratt%20Algorithm
    // https://en.wikipedia.org/wiki/Knuth%E2%80%93Morris%E2%80%93Pratt_algorithm
    static boolean isMatch(String string, String substring) {
        int[] pattern = computePattern(substring);
        int i = 0, j = 0;
        while (i + substring.length() - j <= string.length()) {
            if (string.charAt(i) == substring.charAt(j)) {
                if (j == substring.length() - 1) {
                    return true;
                }
                i++;
                j++;
            }
            else {
                if (j > 0) {
                    j = pattern[j - 1] + 1;
                } else {
                    i++;
                }
            }
        }
        return false;
    }
}
