package linked_list;

public class SingleLinkedList<T> {

    private Node<T> head;
    private Node<T> tail;

    public SingleLinkedList() {
        head = tail = null;
    }

    public Node<T> getHead() {
        return head;
    }

    public void setHead(Node<T> head) {
        this.head = head;
    }

    public Node<T> getTail() {
        return tail;
    }

    public void setTail(Node<T> tail) {
        this.tail = tail;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void clear() {
        head = tail = null;
    }

    public Node<T> addNodeToHead(T x) {
        Node<T> n = new Node<>(x);
        if (isEmpty()) return head = tail = n;
        n.setNext(head);
        head = n;
        return n;
    }

    public Node<T> addNodeToTail(T x) {
        Node<T> n = new Node<>(x);
        if (isEmpty()) return head = tail = n;
        tail.setNext(n);
        tail = n;
        return n;
    }

    public Node<T> addNodeAfter(Node<T> p, T x) {
        if (p == null) return null;
        Node<T> n = new Node<>(x);
        if (isEmpty()) return head = tail = n;
        n.setNext(p.getNext());
        p.setNext(n);
        return n;
    }

    public void addNodeAfter(T px, T x) {
        addNodeAfter(search(px), x);
    }

    public Node<T> removeHead() {
        if (isEmpty()) return null;
        Node<T> n = head;
        head = head.getNext();
        return n;
    }

    public void removeTail() {
        if (isEmpty()) return;
        if (head == tail) {
            clear();
            return;
        }
        Node<T> n = head;
        while (n.getNext() != tail) {
            n = n.getNext();
        }
        n.setNext(null);
        tail = n;
    }

    public Node<T> search(T x) {
        Node<T> n = head;
        while (n != null && !n.getData().equals(x)) {
            n = n.getNext();
        }
        return n;
    }

    public void traverse() {
        if (isEmpty()) {
            System.out.println("Empty list");
            return;
        }
        Node<T> n = head;
        System.out.print("Single Linked List: ");
        while (n != null) {
            System.out.print(n.getData() + " ");
            n = n.getNext();
        }
        System.out.println();
    }
}
