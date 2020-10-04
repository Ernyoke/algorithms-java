package dev.esz.algorithms.tree;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class BinaryTreeTest {

    @Test
    @DisplayName("should invert a binary tree")
    void invertTest() {
        BinaryTree<Integer> binaryTree1 = new BinaryTree<>(1);
        BinaryTree<Integer> binaryTree3 = new BinaryTree<>(3);
        BinaryTree<Integer> binaryTree4 = new BinaryTree<>(4);
        BinaryTree<Integer> binaryTree2 = new BinaryTree<>(2);
        BinaryTree<Integer> binaryTree5 = new BinaryTree<>(5);
        BinaryTree<Integer> binaryTree6 = new BinaryTree<>(6);
        BinaryTree<Integer> binaryTree7 = new BinaryTree<>(7);
        BinaryTree<Integer> binaryTree8 = new BinaryTree<>(8);
        BinaryTree<Integer> binaryTree9 = new BinaryTree<>(9);

        binaryTree1.setLeft(binaryTree2);
        binaryTree1.setRight(binaryTree3);
        binaryTree2.setLeft(binaryTree4);
        binaryTree2.setRight(binaryTree5);
        binaryTree3.setLeft(binaryTree6);
        binaryTree3.setRight(binaryTree7);
        binaryTree4.setLeft(binaryTree8);
        binaryTree4.setRight(binaryTree9);

        binaryTree1.invert();

        assertThat(binaryTree1.traversePreorder()).containsExactly(1, 3, 7, 6, 2, 5, 4, 9, 8);
    }

    @Test
    @DisplayName("should construct the tree from inorder and preorder traversal")
    void constructFromPreorderAndInorderTest() {
        List<Integer> preorder = List.of(1, 2, 4, 8, 9, 10, 11, 5, 3, 6, 7);
        List<Integer> inorder = List.of(8, 4, 10, 9, 11, 2, 5, 1, 6, 3, 7);

        BinaryTree<Integer> binaryTree = BinaryTree.constructFromPreorderAndInorder(preorder, inorder).orElseThrow();
        assertThat(binaryTree.traversePreorder()).containsExactlyElementsOf(preorder);
        assertThat(binaryTree.traverseInorder()).containsExactlyElementsOf(inorder);
    }

    @Test
    @DisplayName("should return lowest common ancestor")
    void lowestCommonAncestorTest1() {
        /*
                     1
                   /   \
                  2     3
                /  \   /  \
               4    5 6    7
              / \
             8   9
         */
        BinaryTree<Integer> binaryTree1 = new BinaryTree<>(1);
        BinaryTree<Integer> binaryTree3 = new BinaryTree<>(3);
        BinaryTree<Integer> binaryTree4 = new BinaryTree<>(4);
        BinaryTree<Integer> binaryTree2 = new BinaryTree<>(2);
        BinaryTree<Integer> binaryTree5 = new BinaryTree<>(5);
        BinaryTree<Integer> binaryTree6 = new BinaryTree<>(6);
        BinaryTree<Integer> binaryTree7 = new BinaryTree<>(7);
        BinaryTree<Integer> binaryTree8 = new BinaryTree<>(8);
        BinaryTree<Integer> binaryTree9 = new BinaryTree<>(9);

        binaryTree1.setLeft(binaryTree2);
        binaryTree1.setRight(binaryTree3);
        binaryTree2.setLeft(binaryTree4);
        binaryTree2.setRight(binaryTree5);
        binaryTree3.setLeft(binaryTree6);
        binaryTree3.setRight(binaryTree7);
        binaryTree4.setLeft(binaryTree8);
        binaryTree4.setRight(binaryTree9);

        Optional<BinaryTree<Integer>> lca = binaryTree1.lowerCommonAncestor(binaryTree9, binaryTree5);

        assertThat(lca.isEmpty()).isFalse();
        assertThat(lca.orElseThrow().getValue()).isEqualTo(2);
    }

    @Test
    @DisplayName("should return lowest common ancestor")
    void lowestCommonAncestorTest2() {
        /*
                     1
                   /   \
                  2     3
                /  \   /  \
               4    5 6    7
              / \
             8   9
         */
        BinaryTree<Integer> binaryTree1 = new BinaryTree<>(1);
        BinaryTree<Integer> binaryTree3 = new BinaryTree<>(3);
        BinaryTree<Integer> binaryTree4 = new BinaryTree<>(4);
        BinaryTree<Integer> binaryTree2 = new BinaryTree<>(2);
        BinaryTree<Integer> binaryTree5 = new BinaryTree<>(5);
        BinaryTree<Integer> binaryTree6 = new BinaryTree<>(6);
        BinaryTree<Integer> binaryTree7 = new BinaryTree<>(7);
        BinaryTree<Integer> binaryTree8 = new BinaryTree<>(8);
        BinaryTree<Integer> binaryTree9 = new BinaryTree<>(9);

        binaryTree1.setLeft(binaryTree2);
        binaryTree1.setRight(binaryTree3);
        binaryTree2.setLeft(binaryTree4);
        binaryTree2.setRight(binaryTree5);
        binaryTree3.setLeft(binaryTree6);
        binaryTree3.setRight(binaryTree7);
        binaryTree4.setLeft(binaryTree8);
        binaryTree4.setRight(binaryTree9);

        Optional<BinaryTree<Integer>> lca = binaryTree1.lowerCommonAncestor(binaryTree1, binaryTree8);

        assertThat(lca.isEmpty()).isFalse();
        assertThat(lca.orElseThrow().getValue()).isEqualTo(1);
    }

    @Test
    @DisplayName("should return empty optional in case of non existent lowest common ancestor")
    void lowestCommonAncestorNonExistentTest2() {
        /*
                     1
                   /   \
                  2     3
                /  \   /  \
               4    5 6    7
              / \
             8   9
         */
        BinaryTree<Integer> binaryTree1 = new BinaryTree<>(1);
        BinaryTree<Integer> binaryTree3 = new BinaryTree<>(3);
        BinaryTree<Integer> binaryTree4 = new BinaryTree<>(4);
        BinaryTree<Integer> binaryTree2 = new BinaryTree<>(2);
        BinaryTree<Integer> binaryTree5 = new BinaryTree<>(5);
        BinaryTree<Integer> binaryTree6 = new BinaryTree<>(6);
        BinaryTree<Integer> binaryTree7 = new BinaryTree<>(7);
        BinaryTree<Integer> binaryTree8 = new BinaryTree<>(8);
        BinaryTree<Integer> binaryTree9 = new BinaryTree<>(9);

        binaryTree1.setLeft(binaryTree2);
        binaryTree1.setRight(binaryTree3);
        binaryTree2.setLeft(binaryTree4);
        binaryTree2.setRight(binaryTree5);
        binaryTree3.setLeft(binaryTree6);
        binaryTree3.setRight(binaryTree7);
        binaryTree4.setLeft(binaryTree8);
        binaryTree4.setRight(binaryTree9);

        Optional<BinaryTree<Integer>> lca = binaryTree1.lowerCommonAncestor(new BinaryTree<>(10), binaryTree8);

        assertThat(lca.isEmpty()).isTrue();
    }
}
