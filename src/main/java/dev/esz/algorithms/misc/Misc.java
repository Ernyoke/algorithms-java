package dev.esz.algorithms.misc;

public interface Misc {
    // Given an integer n, return a string where each character may be present odd number of times.
    // Example: n = 4, possible solutions : xxxy, xyzv, bbba, etc...
    static String oddNumberOfCharacters(int N) {
        if (N <= 0) {
            return "";
        }

        StringBuilder stringBuilder = new StringBuilder();
        int m = 0;
        int rest = 0;
        if (N % 2 == 0) {
            m = N - 1;
            rest = 1;
        } else {
            m = N;
        }

        stringBuilder.append("a".repeat(m));

        if (rest > 0) {
            stringBuilder.append("b");
        }

        return stringBuilder.toString();
    }

    // Compute the longest peak in the array.
    // A peak should consist of minimum 3 elements.
    // A peak should consist of a strictly increasing part until the tip and a strictly decreasing part afterwards.
    // https://www.algoexpert.io/questions/Longest%20Peak
    static int longestPeak(int[] array) {
        if (array == null || array.length < 3) {
            return 0;
        }

        int maxPeakLength = 0;
        int position = 1;
        while (position < array.length) {
            int peakLength = 1;
            boolean upwards = false;
            boolean downwards = false;
            while (position < array.length && array[position - 1] < array[position]) {
                peakLength++;
                position++;
                upwards = true;
            }
            while (position < array.length && array[position - 1] > array[position]) {
                peakLength++;
                position++;
                downwards = true;
            }
            if (position < array.length && array[position - 1] == array[position]) {
                position++;
            }
            if (upwards && downwards && peakLength >= 3) {
                maxPeakLength = Math.max(peakLength, maxPeakLength);
            }
        }

        return maxPeakLength;
    }
}
