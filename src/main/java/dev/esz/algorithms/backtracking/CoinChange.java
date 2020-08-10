package dev.esz.algorithms.backtracking;

// Given an array of coins, return the number of ways that a given amount can be formed with the coins.
// A coin can be used infinite amount of times.
// Original problem: https://www.algoexpert.io/questions/Number%20Of%20Ways%20To%20Make%20Change
public class CoinChange {
    static int numberOfSolutions = 0;
    static int currentSum = 0;

    private static boolean isValid(int amount) {
        return currentSum <= amount;
    }

    private static void solveRecursive(int amount, int[] coins, int position) {
        for (int i = position; i < coins.length; i++) {
            currentSum += coins[i];
            if (currentSum == amount) {
                numberOfSolutions++;
            } else {
                if (isValid(amount)) {
                    solveRecursive(amount, coins, i);
                }
            }
            currentSum -= coins[i];
        }
    }

    public static int numberOfWaysToMakeChange(int amount, int[] coins) {
        if (amount == 0) {
            return 1;
        }
        solveRecursive(amount, coins, 0);
        return numberOfSolutions;
    }
}
