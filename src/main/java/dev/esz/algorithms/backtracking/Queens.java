package dev.esz.algorithms.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public interface Queens {
    private static boolean isSafe(final int[] position, final int row) {
        for (int i = 0; i < row; i++) {
            if (position[i] == position[row] || Math.abs(row - i) == Math.abs(position[row] - position[i])) {
                return false;
            }
        }
        return true;
    }

    private static void solveRecursive(final int[] position, final int row, List<int[]> solutions) {
        for (int i = 0; i < position.length; i++) {
            position[row] = i;
            if (isSafe(position, row)) {
                if (row == position.length - 1) {
                    solutions.add(Arrays.copyOf(position, position.length));
                } else {
                    solveRecursive(position, row + 1, solutions);
                }
            }
        }
    }

    static List<int[]> solveRecursive(final int n) {
        final int[] position = new int[n];
        final List<int[]> solutions = new ArrayList<>();
        solveRecursive(position, 0, solutions);
        return solutions;
    }

    static List<int[]> solveIterative(final int n) {
        final int[] position = new int[n];
        final List<int[]> solutions = new ArrayList<>();
        int column = 0;
        int row = 0;
        do {
            while (column < n) {
                position[row] = column;
                if (isSafe(position, row)) {
                    row++;
                    column = 0;
                    break;
                }
                column++;
            }

            if (row == n || column == n) {
                if (row == n) {
                    solutions.add(Arrays.copyOf(position, position.length));
                }

                row--;
                if (row >= 0) {
                    column = 1 + position[row];
                }
            }
        } while (row >= 0);

        return solutions;
    }
}
