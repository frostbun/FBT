package binary_search_tree;

import java.util.List;

import linked_list.Queue;

public class BinarySearchTree<T extends Comparable<T>> {

    private BNode<T> root;

    public boolean isEmpty() {
        return root == null;
    }

    public void clear() {
        root = null;
    }

    public void add(T value) {
        if (isEmpty()) {
            root = new BNode<T>(value);
            return;
        }
        BNode<T> curr = root;
        while (true) {
            int cmp = curr.getValue().compareTo(value);
            if (cmp == 0) {
                return;
            }
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

    // private BNode<T> getLeftMost(BNode<T> node) {
    //     if (node == null) return null;
    //     BNode<T> curr = node;
    //     while (curr.hasLeft()) {
    //         curr = curr.getLeft();
    //     }
    //     return curr;
    // }

    private BNode<T> getRightMost(BNode<T> node) {
        if (node == null) return null;
        BNode<T> curr = node;
        while (curr.hasRight()) {
            curr = curr.getRight();
        }
        return curr;
    }

    private BNode<T> getParrent(BNode<T> node) {
        if (node == null) return null;
        BNode<T> curr = root;
        while (curr != null) {
            if (curr.getLeft() == node || curr.getRight() == node) {
                return curr;
            }
            int cmp = curr.compareTo(node);
            if (cmp > 0) curr = curr.getLeft();
            else curr = curr.getRight();
        }
        return null;
    }

    private BNode<T> search(T value) {
        BNode<T> curr = root;
        while (curr != null) {
            int cmp = curr.getValue().compareTo(value);
            if (cmp == 0) {
                return curr;
            }
            if (cmp > 0) curr = curr.getLeft();
            if (cmp < 0) curr = curr.getRight();
        }
        return null;
    }

    public void remove(T value) {
        if (isEmpty()) {
            return;
        }
        if (root.getValue().equals(value)) {
            clear();
            return;
        }
        BNode<T> node = search(value);
        BNode<T> parrent = getParrent(node);
        getRightMost(node.getLeft()).setRight(node.getRight());
        if (node == parrent.getLeft()) {
            parrent.setLeft(node.getLeft());
        }
        else {
            parrent.setRight(node.getLeft());
        }
    }

    public void bfs() {
        Queue<BNode<T>> queue = new Queue<>();
        if (!isEmpty()) queue.enqueue(root);
        while (!queue.isEmpty()) {
            BNode<T> node = queue.dequeue();
            if (node.hasLeft()) queue.enqueue(node.getLeft());
            if (node.hasRight()) queue.enqueue(node.getRight());
            System.out.printf("%d ", node.getValue());
        }
        System.out.println();
    }

    public static <T extends Comparable<T>> BinarySearchTree<T> build(List<T> list) {
        BinarySearchTree<T> tree = new BinarySearchTree<>();
        list.forEach(value -> tree.add(value));
        return tree;
    }
}
