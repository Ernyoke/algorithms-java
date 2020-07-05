package dev.esz.algorithms.backtracking;

public class SplitInto3Parts {
    private int nrOfAs = 0;
    private int nrSolutions = 0;

    // Given a string of "a" and "b" characters, split the string into 3 parts, where each part contains the same number
    // of "a". Return the number of possible solutions.
    // Example:
    // ababa: [a, ba, ba], [ab, ab, a], [ab, a, ba], [a, bab, a] - returned value should be 4.
    public int solution(String string) {
        if (string == null || string.length() <= 0) {
            return 0;
        }
        int countA = 0;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == 'a') {
                countA++;
            }
        }
        if (countA % 3 != 0) {
            return 0;
        }

        nrOfAs = countA / 3;

        solveRecursive(string, 0);

        return nrSolutions;
    }

    private boolean isValid(String string) {
        int countA = 0;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == 'a') {
                countA++;
            }
            if (countA > nrOfAs) {
                return false;
            }
        }
        return nrOfAs == countA;
    }

    private void solveRecursive(String string, int level) {
        for (int i = 1; i <= string.length(); i++) {
            if (level < 2) {
                if (isValid(string.substring(0, i))) {
                    solveRecursive(string.substring(i), level + 1);
                }
            }
            if (level == 2) {
                if (isValid(string)) {
                    nrSolutions++;
                }
                break;
            }
        }
    }
}
