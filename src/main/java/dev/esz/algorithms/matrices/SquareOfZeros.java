package dev.esz.algorithms.matrices;

import java.util.ArrayList;
import java.util.List;

public interface SquareOfZeros {
    private static List<List<List<Integer>>> computeZeroBounds(List<List<Integer>> matrix) {
        List<List<List<Integer>>> zeroBounds = new ArrayList<>();
        for (int i = 0; i < matrix.size(); i++) {
            List<List<Integer>> zeroBoundsLine = new ArrayList<>();
            zeroBounds.add(zeroBoundsLine);
            List<Integer> matrixLine = matrix.get(i);
            for (int j = 0; j < matrix.size(); j++) {
                if (matrixLine.get(j) == 1) {
                    zeroBoundsLine.add(new ArrayList<>(List.of(0)));
                } else {
                    int previous = 0;
                    if (j > 0) {
                        previous = zeroBoundsLine.get(j - 1).get(0);
                    }
                    if (previous > 0) {
                        zeroBoundsLine.add(new ArrayList<>(List.of(previous - 1)));
                    } else {
                        int count = 0;
                        for (int k = j; k < matrix.size(); k++) {
                            if (matrixLine.get(k) == 0) {
                                count++;
                                if (k == matrix.size() - 1) {
                                    zeroBoundsLine.add(new ArrayList<>(List.of(count)));
                                }
                            } else {
                                zeroBoundsLine.add(new ArrayList<>(List.of(count)));
                                break;
                            }
                        }
                    }
                }
            }
        }

        for (int j = 0; j < matrix.size(); j++) {
            for (int i = 0; i < matrix.size(); i++) {
                if (matrix.get(i).get(j) == 1) {
                    zeroBounds.get(i).get(j).add(0);
                } else {
                    int previous = 0;
                    if (i > 0) {
                        previous = zeroBounds.get(i - 1).get(j).get(1);
                    }
                    if (previous > 0) {
                        zeroBounds.get(i).get(j).add(previous - 1);
                    } else {
                        int count = 0;
                        for (int k = i; k < matrix.size(); k++) {
                            if (matrix.get(k).get(j) == 0) {
                                count++;
                                if (k == matrix.size() - 1) {
                                    zeroBounds.get(i).get(j).add(count);
                                }
                            } else {
                                zeroBounds.get(i).get(j).add(count);
                                break;
                            }
                        }
                    }
                }
            }
        }
        return zeroBounds;
    }

    // Input: NxN matrix which can contain 0s and 1s.
    // Should return true if the matrix contains a square with having bounds of 0s only
    // Example:
    // 1 1 1 1 1
    // 1 0 0 0 0
    // 1 0 1 1 0
    // 1 0 1 0 0
    // 0 0 0 0 0
    // The return value should be true because there is a square [1,1; 4,4]
    //
    // https://www.algoexpert.io/questions/Square%20of%20Zeroes
    static boolean doesHaveSquareWithZeroBounds(List<List<Integer>> matrix) {
        List<List<List<Integer>>> zeroBounds = computeZeroBounds(matrix);
        for (int i = 0; i < matrix.size(); i++) {
            for (int j = 0; j < matrix.size(); j++) {
                List<Integer> bounds = zeroBounds.get(i).get(j);
                int row = bounds.get(0);
                int column = bounds.get(1);
                if (column > 1 && row > 1) {
                    for (int k = 1; k + i < matrix.size() && k + j < matrix.size(); k++) {
                        int otherColumn = zeroBounds.get(i).get(j + k).get(1);
                        int otherRow = zeroBounds.get(i + k).get(j).get(0);
                        if (otherColumn >= column - 1 && otherRow >= row - 1 && otherColumn > 1 && otherRow > 1) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}
