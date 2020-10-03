package dev.esz.algorithms.tree;

// Compute the max path sum.

// Example:
/*
             1
           /   \
          2     3
         / \   / \
        4   5 6   7
 */
// Max path sum: 18 -> 5 + 2 + 1 + 3 + 7

// Original problem: https://www.algoexpert.io/questions/Max%20Path%20Sum%20In%20Binary%20Tree
public class MaxPathSum {

    public static int maxPathSum(BinaryTree tree) {
        if (tree != null) {
            int currentSum = tree.value + Math.max(computeMaxPath(tree.left), 0) + Math.max(computeMaxPath(tree.right), 0);
            return Math.max(currentSum, Math.max(maxPathSum(tree.left), maxPathSum(tree.right)));
        }
        return 0;
    }

    public static int computeMaxPath(BinaryTree tree) {
        if (tree == null) {
            return 0;
        }
        return tree.value + Math.max(MaxPathSum.computeMaxPath(tree.left), MaxPathSum.computeMaxPath(tree.right));
    }

    static class BinaryTree {
        public int value;
        public BinaryTree left;
        public BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
        }
    }
}
