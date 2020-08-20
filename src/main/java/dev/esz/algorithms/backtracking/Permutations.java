package dev.esz.algorithms.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Take an array of integers and return all of its permutations.
public class Permutations {
    public static List<List<Integer>> getPermutations(List<Integer> array) {
        if (array == null || array.isEmpty()) {
            return Collections.emptyList();
        }
        List<List<Integer>> solutions = new ArrayList<>();
        solveRecursive(array, new ArrayList<>(), solutions);
        return solutions;
    }

    private static boolean isValid(List<Integer> solution, Integer value) {
        return !solution.contains(value);
    }

    private static void solveRecursive(List<Integer> array, List<Integer> currentSolution, List<List<Integer>> solutions) {
        if (currentSolution.size() == array.size()) {
            solutions.add(List.copyOf(currentSolution));
        } else {
            for (Integer value : array) {
                if (isValid(currentSolution, value)) {
                    currentSolution.add(value);
                    solveRecursive(array, currentSolution, solutions);
                    currentSolution.remove(currentSolution.size() - 1);
                }
            }
        }
    }
}
