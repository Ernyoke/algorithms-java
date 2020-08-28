package dev.esz.algorithms.misc;

// Any number will be called a happy number if, after repeatedly replacing it with a number equal to the sum of the
// square of all of its digits, leads us to number ‘1’. All other (not-happy) numbers will never reach ‘1’. Instead,
// they will be stuck in a cycle of numbers which does not include ‘1’.
// Original problem: https://www.educative.io/courses/grokking-the-coding-interview/39q3ZWq27jM
public class HappyNumber {
    static boolean find(int number) {
        int slow = number;
        int fast = number;
        do {
            slow = squareSum(slow);
            fast = squareSum(squareSum(fast));
            if (slow == fast) {
                return slow == 1;
            }
        } while (true);
    }

    private static int squareSum(int number) {
        int result = 0;
        while (number > 0) {
            result += Math.pow(number % 10, 2);
            number /= 10;
        }
        return result;
    }
}
