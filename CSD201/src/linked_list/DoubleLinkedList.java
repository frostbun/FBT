package linked_list;

public class DoubleLinkedList<T> {

    private DNode<T> head;
    private DNode<T> tail;

    public DoubleLinkedList() {
        head = tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void clear() {
        head = tail = null;
    }

    public DNode<T> search(T data) {
        DNode<T> n = head;
        while (n != null && !n.getData().equals(data)) {
            n = n.getNext();
        }
        return n;
    }

    public DNode<T> addNodeToHead(T data) {
        DNode<T> n = new DNode<>(data);
        if (head == null) {
            head = tail = n;
        }
        else {
            n.setNext(head);
            head.setPrev(n);
            head = n;
        }
        return n;
    }

    public DNode<T> addNodeToTail(T data) {
        DNode<T> n = new DNode<>(data);
        if (head == null) {
            head = tail = n;
        }
        else {
            tail.setNext(n);
            n.setPrev(tail);
            tail = n;
        }
        return n;
    }

    public DNode<T> addNodeAfter(DNode<T> node, T data) {
        if (node == null) return null;
        DNode<T> n = new DNode<>(data);
        n.setPrev(node);
        if (node.hasNext()) {
            DNode<T> next = node.getNext();
            n.setNext(next);
            next.setPrev(n);
        }
        node.setNext(n);
        return n;
    }

    public DNode<T> addNodeAfter(T node, T data) {
        return addNodeAfter(search(node), data);
    }

    public DNode<T> addNodeBefore(DNode<T> node, T data) {
        if (node == null) return null;
        DNode<T> n = new DNode<>(data);
        n.setNext(node);
        if (node.hasPrev()) {
            DNode<T> prev = node.getPrev();
            n.setPrev(prev);
            prev.setNext(n);
        }
        node.setPrev(n);
        return n;
    }

    public DNode<T> addNodeBefore(T node, T data) {
        return addNodeBefore(search(node), data);
    }

    public DNode<T> removeNode(DNode<T> node) {
        if (node == null) return null;
        node.getPrev().setNext(node.getNext());
        node.getNext().setPrev(node.getPrev());
        return node;
    }

    public DNode<T> removeNode(T data) {
        return removeNode(search(data));
    }

    public DNode<T> removeHead() {
        return removeNode(head);
    }

    public DNode<T> removeTail() {
        return removeNode(tail);
    }

    public void traverse() {
        if (isEmpty()) {
            System.out.println("Empty list");
            return;
        }
        DNode<T> n = head;
        System.out.print("Double Linked List: ");
        while (n != null) {
            System.out.print(n.getData() + " ");
            n = n.getNext();
        }
        System.out.println();
    }

    public void traverseFromTail() {
        if (isEmpty()) {
            System.out.println("Empty list");
            return;
        }
        DNode<T> n = tail;
        System.out.print("Double Linked List: ");
        while (n != null) {
            System.out.print(n.getData() + " ");
            n = n.getPrev();
        }
        System.out.println();
    }
}
