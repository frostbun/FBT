package sort;

import java.util.List;

public class TreeSort<T extends Comparable<T>> {

    public static <T extends Comparable<T>> List<T> sort(List<T> list) {
        BinarySearchTree<T> tree = new BinarySearchTree<>(list);
        list.clear();
        return tree.inorderTraverse(list);
    }
}

class BinarySearchTree<T extends Comparable<T>> {

    private BNode<T> root;

    public BinarySearchTree(List<T> list) {
        list.forEach(value -> add(value));
    }

    public boolean isEmpty() {
        return this.root == null;
    }

    public void add(T value) {
        if (isEmpty()) {
            root = new BNode<T>(value);
            return;
        }
        BNode<T> curr = root;
        while (true) {
            if (curr.getValue().compareTo(value) > 0) {
                if (curr.hasLeft()) {
                    curr = curr.getLeft();
                }
                else {
                    curr.setLeft(new BNode<T>(value));
                    return;
                }
            }
            else {
                if (curr.hasRight()) {
                    curr = curr.getRight();
                }
                else {
                    curr.setRight(new BNode<T>(value));
                    return;
                }
            }
        }
    }

    private void inorderTraverse(BNode<T> node, List<T> list) {
        if (node == null) return;
        inorderTraverse(node.getLeft(), list);
        list.add(node.getValue());
        inorderTraverse(node.getRight(), list);
    }

    public List<T> inorderTraverse(List<T> list) {
        if (!isEmpty()) inorderTraverse(root, list);
        return list;
    }
}

class BNode<T extends Comparable<T>> implements Comparable<BNode<T>> {

    private final T value;
    private BNode<T> left;
    private BNode<T> right;

    public BNode(T value, BNode<T> left, BNode<T> right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public BNode(T value) {
        this(value, null, null);
    }

    public T getValue() {
        return this.value;
    }

    public BNode<T> getLeft() {
        return this.left;
    }

    public void setLeft(BNode<T> left) {
        this.left = left;
    }

    public BNode<T> getRight() {
        return this.right;
    }

    public void setRight(BNode<T> right) {
        this.right = right;
    }

    public boolean hasLeft() {
        return this.left != null;
    }

    public boolean hasRight() {
        return this.right != null;
    }

    public BNode<T> left(BNode<T> left) {
        this.setLeft(left);
        return this;
    }

    public BNode<T> right(BNode<T> right) {
        this.setRight(right);
        return this;
    }

    public int compareTo(BNode<T> other) {
        return this.value.compareTo(other.value);
    }
}
