package asm1;

import java.util.LinkedList;
import java.util.List;

public class BinarySearchTree<T extends Comparable<T>> {

    private BNode<T> root;

    public boolean isEmpty() {
        return this.root == null;
    }

    public void add(T value) {
        if (this.isEmpty()) {
            root = new BNode<T>(value);
            return;
        }
        BNode<T> curr = root;
        int cmp;
        while ((cmp = curr.getValue().compareTo(value)) != 0) {
            if (cmp > 0) {
                if (curr.hasLeft()) {
                    curr = curr.getLeft();
                }
                else {
                    curr.setLeft(new BNode<T>(value));
                    return;
                }
            }
            if (cmp < 0) {
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

    private BNode<T> search(T value) {
        BNode<T> curr = root;
        while (curr != null) {
            int cmp = curr.getValue().compareTo(value);
            if (cmp == 0) return curr;
            if (cmp > 0) curr = curr.getLeft();
            if (cmp < 0) curr = curr.getRight();
        }
        return null;
    }

    public T get(T value) {
        BNode<T> node = this.search(value);
        return node != null ? node.getValue() : null;
    }

    public List<T> getAll() {
        List<T> valueList = new LinkedList<>();
        List<BNode<T>> queue = new LinkedList<>();
        if (!isEmpty()) queue.add(root);
        while (!queue.isEmpty()) {
            BNode<T> node = queue.remove(0);
            valueList.add(node.getValue());
            if (node.hasLeft()) queue.add(node.getLeft());
            if (node.hasRight()) queue.add(node.getRight());
        }
        return valueList;
    }
}
