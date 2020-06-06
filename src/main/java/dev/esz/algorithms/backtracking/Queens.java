package dev.esz.algorithms.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public interface Queens {
    private static boolean isSafe(final int[] position, final int column) {
        for (int i = 0; i < column; i++) {
            if (position[i] == position[column] || Math.abs(column - i) == Math.abs(position[column] - position[i])) {
                return false;
            }
        }
        return true;
    }

    private static void solve(final int[] position, final int column, List<int[]> solutions) {
        for (int i = 0; i < position.length; i++) {
            position[column] = i;
            if (isSafe(position, column)) {
                if (column == position.length - 1) {
                    solutions.add(Arrays.copyOf(position, position.length));
                } else {
                    solve(position, column + 1, solutions);
                }
            }
        }
    }

    static List<int[]> solve(final int n) {
        final int[] position = new int[n];
        List<int[]> solutions = new ArrayList<>();
        solve(position, 0, solutions);
        return solutions;
    }
}
