package dev.esz.algorithms.backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// For a given number ‘N’, write a function to generate all combination of ‘N’ pairs of balanced parentheses.

// Original problem: https://www.educative.io/courses/grokking-the-coding-interview/NEXBg8YA5A2
public class BalancedParentheses {
    private static final String[] PARENTHESES = {"(", ")"};

    public static List<String> generateValidParentheses(int num) {
        List<List<String>> result = new ArrayList<>();
        generateRecursive(new ArrayList<>(), num, result);
        return result.stream()
                .map(r -> r.stream().reduce("", (a, b) -> a + b))
                .collect(Collectors.toList());
    }

    private static void generateRecursive(List<String> current, int num, List<List<String>> result) {
        boolean validPartialResult = isValid(current, num);
        if (!validPartialResult) {
            return;
        }
        if (current.size() >= 2 * num) {
            result.add(List.copyOf(current));
            return;
        }
        for (String p : PARENTHESES) {
            current.add(p);
            generateRecursive(current, num, result);
            current.remove(current.size() - 1);
        }
    }

    private static boolean isValid(List<String> current, int num) {
        int runningSum = 0;
        int openParenthesisCount = 0;
        for (String p : current) {
            if (p.equals("(")) {
                openParenthesisCount++;
                runningSum++;
            } else if (p.equals(")")) {
                runningSum--;
            }
            if (openParenthesisCount > num || runningSum < 0) {
                return false;
            }
        }
        return true;
    }
}
