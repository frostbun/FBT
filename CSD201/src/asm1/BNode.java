package asm1;

public class BNode<T extends Comparable<T>> implements Comparable<BNode<T>> {

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

    public boolean equals(BNode<T> other) {
        return this.value.equals(other.value);
    }

    public int compareTo(BNode<T> other) {
        return this.value.compareTo(other.value);
    }
}
