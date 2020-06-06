package dev.esz.algorithms.strings;

public interface Misc {
    static boolean isPalindrome(String string) {
        int middle = string.length() / 2;
        for (int i = 0; i < middle; i++) {
            if (string.charAt(i) != string.charAt(string.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
