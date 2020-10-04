package dev.esz.algorithms.tree;

import dev.esz.algorithms.collections.Search;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

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

    public T getValue() {
        return value;
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
            traverseInorderRecursive(root.left, nodes);
            nodes.add(root.value);
            traverseInorderRecursive(root.right, nodes);
        }
    }

    public List<T> traversePreorder() {
        List<T> nodes = new ArrayList<>();
        traversePreorderRecursive(this, nodes);
        return nodes;
    }

    private void traversePreorderRecursive(BinaryTree<T> root, List<T> nodes) {
        if (root != null) {
            nodes.add(root.value);
            traversePreorderRecursive(root.left, nodes);
            traversePreorderRecursive(root.right, nodes);
        }
    }

    // Given the preorder and inorder travers, reconstruct the original tree.
    public static <T> Optional<BinaryTree<T>> constructFromPreorderAndInorder(List<T> preorder, List<T> inorder) {
        if (preorder == null || inorder == null || preorder.isEmpty() || inorder.isEmpty()) {
            return Optional.empty();
        }
        return Optional.ofNullable(constructFromPreorderAndInorderRecursive(preorder, inorder));
    }

    private static <T> BinaryTree<T> constructFromPreorderAndInorderRecursive(List<T> preorder, List<T> inorder) {
        if (preorder.isEmpty() || inorder.isEmpty()) {
            return null;
        }
        T rootValue = preorder.get(0);
        int position = Search.linearSearch(inorder, rootValue::equals).orElseThrow();
        return new BinaryTree<T>(rootValue,
                constructFromPreorderAndInorderRecursive(preorder.subList(1, preorder.size()), inorder.subList(0, position)),
                constructFromPreorderAndInorderRecursive(preorder.subList(position + 1, preorder.size()), inorder.subList(position + 1, inorder.size())));
    }

    // Find lower common ancestor for two nodes.
    public Optional<BinaryTree<T>> lowerCommonAncestor(BinaryTree<T> node1, BinaryTree<T> node2) {
        if (Objects.isNull(node1) || Objects.isNull(node2)) {
            return Optional.empty();
        }
        BinaryTree<T> self = this;
        boolean[] nodesFound = {false, false};
        BinaryTree<T> lcaNode = lowestCommonAncestorRecursive(self, node1, node2, nodesFound);

        if (nodesFound[0] == nodesFound[1]) {
            return Optional.ofNullable(lcaNode);
        }
        return Optional.empty();
    }

    private BinaryTree<T> lowestCommonAncestorRecursive(BinaryTree<T> self, BinaryTree<T> node1, BinaryTree<T> node2, boolean[] nodesFound) {
        if (Objects.isNull(self)) {
            return null;
        }

        if (self == node1) {
            nodesFound[0] = true;
            return node1;
        }
        if (self == node2) {
            nodesFound[1] = true;
            return node2;
        }

        BinaryTree<T> lefLowestCommonAncestor = lowestCommonAncestorRecursive(self.left, node1, node2, nodesFound);
        BinaryTree<T> rightLowestCommonAncestor = lowestCommonAncestorRecursive(self.right, node1, node2, nodesFound);

        if (!Objects.isNull(lefLowestCommonAncestor) && !Objects.isNull(rightLowestCommonAncestor)) {
            return self;
        }

        return !Objects.isNull(lefLowestCommonAncestor) ? lefLowestCommonAncestor : rightLowestCommonAncestor;
    }
}
