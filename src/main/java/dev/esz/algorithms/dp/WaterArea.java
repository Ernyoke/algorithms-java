package dev.esz.algorithms.dp;

import java.util.Arrays;

public interface WaterArea {
    // Given an array on non-negative integers where each integer represents a height, compute the surface area of
    // the water the can be trapped between the heights. Spilled water should be ignored.
    // Original problem: https://www.algoexpert.io/questions/Water%20Area
    static int computeArea(int[] heights) {
        int[] leftMaxes = new int[heights.length];
        int leftMax = 0;
        for (int i = 0; i < heights.length; i++) {
            leftMaxes[i] = leftMax;
            leftMax = Math.max(leftMax, heights[i]);
        }

        int[] water = new int[heights.length];
        int rightMax = 0;
        for (int i = heights.length - 1; i >= 0; i--) {
            water[i] = Math.max(Math.min(leftMaxes[i], rightMax) - heights[i], 0);
            rightMax = Math.max(rightMax, heights[i]);
        }

        return Arrays.stream(water).sum();
    }
}
