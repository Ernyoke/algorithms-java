package dev.esz.algorithms.tree;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MaxPathSumTest {

    @Test
    @DisplayName("should compute the maximum path")
    void maxPathSum() {
        MaxPathSum.BinaryTree binaryTree = new MaxPathSum.BinaryTree(1);
        binaryTree.left = new MaxPathSum.BinaryTree(2);
        binaryTree.right = new MaxPathSum.BinaryTree(3);
        binaryTree.left.left = new MaxPathSum.BinaryTree(4);
        binaryTree.left.right = new MaxPathSum.BinaryTree(5);
        binaryTree.right.left = new MaxPathSum.BinaryTree(6);
        binaryTree.right.right = new MaxPathSum.BinaryTree(7);

        assertThat(MaxPathSum.maxPathSum(binaryTree)).isEqualTo(18);
    }

    @Test
    @DisplayName("should compute the maximum path")
    void maxPathSum2() {
        MaxPathSum.BinaryTree binaryTree = new MaxPathSum.BinaryTree(1);
        binaryTree.left = new MaxPathSum.BinaryTree(2);
        binaryTree.right = new MaxPathSum.BinaryTree(-1);

        assertThat(MaxPathSum.maxPathSum(binaryTree)).isEqualTo(3);
    }
}
