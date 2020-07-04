package dev.esz.algorithms.matrices;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public interface RiverSizes {
    class Position {
        final int x, y;

        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    // Flood fill algorithm
    // https://en.wikipedia.org/wiki/Flood_fill

    // Given a 2D array which can contain only 0 and 1 integers. 0 means land, 1 means river. A river consists of 1s
    // which can be either horizontally, either vertically adjacent (not diagonally). Return the length of all rivers.

    // Original problem: https://www.algoexpert.io/questions/River%20Sizes
    static List<Integer> riverSizes(int[][] matrix) {
        List<Integer> rivers = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return rivers;
        }
        boolean[][] touched = new boolean[matrix.length][matrix[0].length];
        Queue<Position> stack = new LinkedList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int riverSize = 0;
                if (matrix[i][j] == 1 && !touched[i][j]) {
                    stack.add(new Position(i, j));
                    touched[i][j] = true;
                    while (!stack.isEmpty()) {
                        riverSize++;
                        Position position = stack.poll();
                        int up = position.x - 1;
                        int down = position.x + 1;
                        int left = position.y - 1;
                        int right = position.y + 1;
                        if (up >= 0 && !touched[up][position.y] && matrix[up][position.y] == 1) {
                            touched[up][position.y] = true;
                            stack.add(new Position(up, position.y));
                        }
                        if (left >= 0 && !touched[position.x][left] && matrix[position.x][left] == 1) {
                            touched[position.x][left] = true;
                            stack.add(new Position(position.x, left));
                        }
                        if (down < matrix.length && !touched[down][position.y] && matrix[down][position.y] == 1) {
                            touched[down][position.y] = true;
                            stack.add(new Position(down, position.y));
                        }
                        if (right < matrix[0].length && !touched[position.x][right] && matrix[position.x][right] == 1) {
                            touched[position.x][right] = true;
                            stack.add(new Position(position.x, right));
                        }
                    }
                    rivers.add(riverSize);
                }
            }
        }
        return rivers;
    }
}
