package linked_list;

public class Queue<T> {

    private SingleLinkedList<T> list;

    public Queue() {
        list = new SingleLinkedList<>();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void clear() {
        list.clear();
    }

    public void enqueue(T x) {
        list.addNodeToTail(x);
    }

    public T top() {
        if (isEmpty()) return null;
        return list.getHead().getData();
    }

    public T dequeue() {
        if (isEmpty()) return null;
        return list.removeHead().getData();
    }
}
