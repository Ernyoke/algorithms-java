package dev.esz.algorithms.misc;

public class Misc {
    // Given an integer n, return a string where each character may be present odd number of times.
    // Example: n = 4, possible solutions : xxxy, xyzv, bbba, etc...
    public String oddNumberOfCharacters(int N) {
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
}
