package dev.esz.algorithms.tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree<T> {
    private final T value;
    private BinaryTree<T> left;
    private BinaryTree<T> right;

    public BinaryTree(T value) {
        this.value = value;
    }

    public BinaryTree(T value, BinaryTree<T> left, BinaryTree<T> right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public void setLeft(BinaryTree<T> left) {
        this.left = left;
    }

    public BinaryTree<T> getLeft() {
        return left;
    }

    public void setRight(BinaryTree<T> right) {
        this.right = right;
    }

    public BinaryTree<T> getRight() {
        return right;
    }

    // Invert the binary tree.
    public void invert() {
        invertRecursive(this);
    }

    private void invertRecursive(BinaryTree<T> root) {
        if (root != null) {
            invertRecursive(root.left);
            invertRecursive(root.right);
            BinaryTree<T> aux = root.left;
            root.left = root.right;
            root.right = aux;
        }
    }

    public List<T> traverseInorder() {
        List<T> nodes = new ArrayList<>();
        traverseInorderRecursive(this, nodes);
        return nodes;
    }

    private void traverseInorderRecursive(BinaryTree<T> root, List<T> nodes) {
        if (root != null) {
            nodes.add(root.value);
            traverseInorderRecursive(root.left, nodes);
            traverseInorderRecursive(root.right, nodes);
        }
    }
}
